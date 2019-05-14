package com.example.kooperatywalubelska.database;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.kooperatywalubelska.Webservice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderRepository {

    protected final Webservice webservice;
    protected final OrderDao orderDao;
    private final Executor executor;

    @Inject
    public OrderRepository(Webservice webservice, OrderDao orderDao, Executor executor) {
        this.webservice = webservice;
        this.orderDao = orderDao;
        this.executor = executor;
    }

    Callback<Order> saveOrderCallback = new Callback<Order>() {
        @Override
        public void onResponse(Call<Order> call, Response<Order> response) {
            Log.e("TAG", "DATA REQUEST " + call.request().toString());
            executor.execute(() -> {
                Order entity = response.body();
                entity.setLastRefresh(new Date());
                orderDao.save(entity);
                Log.e("TAG", entity.toString());
            });
        }

        @Override
        public void onFailure(Call<Order> call, Throwable t) {
            Log.e("TAG", "Call<Order>: " + call.toString());
            Log.e("TAG", "Request: " + call.request().toString());
            Log.e("TAG", "Request.body: " + call.request().body());
            Log.e("TAG", "Throwable: " + t.toString());
        }
    };

    private void refreshOrder(final Date date, String userId) {
        executor.execute(() -> {
            Order order = orderDao.hasOrder(date, EntityRepository.getMaxRefreshTime(new Date()));
            boolean orderNotExists = order == null;
            if (orderNotExists) {
                String pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                Log.e("TAG", "ENTITY NOT EXISTS " + simpleDateFormat.format(date));
                webservice.getOrder(simpleDateFormat.format(date), userId).enqueue(saveOrderCallback);
            } else
                Log.e("TAG", "ENTITY EXISTS " + order.toString());
        });
    }

    public LiveData<Order> getOrder(Date orderDate, String userId) {
        refreshOrder(orderDate, userId);
        return orderDao.loadOrder(orderDate);
    }

}
