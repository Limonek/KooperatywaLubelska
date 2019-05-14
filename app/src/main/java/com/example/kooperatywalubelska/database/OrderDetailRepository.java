package com.example.kooperatywalubelska.database;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.kooperatywalubelska.Webservice;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderDetailRepository {

    protected final Webservice webservice;
    protected final OrderDetailDao orderDetailDao;
    private final Executor executor;
    private String oderDetailsDeleteOrderId;

    @Inject
    public OrderDetailRepository(Webservice webservice, OrderDetailDao orderDetailDao, Executor executor) {
        this.webservice = webservice;
        this.orderDetailDao = orderDetailDao;
        this.executor = executor;
    }

    public LiveData<List<OrderDetail>> getOrderOrderDetails(String orderId) {
        refreshOrderOrderDetails(orderId);
        return orderDetailDao.loadOrderOrderDetails(orderId);
    }

    private Callback<GsonListDecorator<OrderDetail>> entitiesToUpdateCallback = new Callback<GsonListDecorator<OrderDetail>>() {
        @Override
        public void onResponse(Call<GsonListDecorator<OrderDetail>> call, Response<GsonListDecorator<OrderDetail>> response) {
            Log.e("TAG", "DATA REQUEST " + call.request().toString());
            executor.execute(() -> {
                GsonListDecorator<OrderDetail> gsonListDecorator = response.body();
                if (response.body().getArrayList() != null)
                    for (OrderDetail orderDetail : gsonListDecorator.getArrayList()) {
                        orderDetailDao.save(orderDetail);
                        Log.e("TAG", orderDetail.toString());
                    }
            });
        }

        @Override
        public void onFailure(Call<GsonListDecorator<OrderDetail>> call, Throwable t) {
            Log.e("TAG", "Call<GsonListDecorator<OrderDetail>>: " + call.toString());
            Log.e("TAG", "Call<GsonListDecorator<OrderDetail>>.request: " + call.request().toString());
            Log.e("TAG", "Throwable: " + t.toString());
        }
    };

    Callback<GsonListDecorator<Integer>> deleteAllButSpecifiedIdsCallback = new Callback<GsonListDecorator<Integer>>() {
        @Override
        public void onResponse(Call<GsonListDecorator<Integer>> call, Response<GsonListDecorator<Integer>> response) {
            executor.execute(() -> {
                GsonListDecorator<Integer> integerList = response.body();
                orderDetailDao.deleteAllOrderOrderDetailsExcept(integerList.getArrayList(), OrderDetailRepository.this.oderDetailsDeleteOrderId);
            });
        }

        @Override
        public void onFailure(Call<GsonListDecorator<Integer>> call, Throwable t) {
            Log.e("TAG", "Call<IntegerList>: " + call.toString());
            Log.e("TAG", "Call<IntegerList>.request: " + call.request().toString());
            Log.e("TAG", "Throwable: " + t.toString());
        }
    };

    public void refreshOrderOrderDetails(String orderId) {
        executor.execute(() -> {
            webservice.getOrderOrderDetails(orderId).enqueue(entitiesToUpdateCallback);
            webservice.getExistingOrderOrderIds(orderId).enqueue(deleteAllButSpecifiedIdsCallback);
            oderDetailsDeleteOrderId = orderId;
        });
    }

}
