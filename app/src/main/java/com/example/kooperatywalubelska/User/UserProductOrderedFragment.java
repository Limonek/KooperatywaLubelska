package com.example.kooperatywalubelska.User;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kooperatywalubelska.R;
import com.example.kooperatywalubelska.database.Order;
import com.example.kooperatywalubelska.database.OrderDetail;
import com.example.kooperatywalubelska.viewmodels.OrderDetailViewModel;
import com.example.kooperatywalubelska.viewmodels.OrderDetailViewModelFactory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;

import static android.content.Context.MODE_PRIVATE;

public class UserProductOrderedFragment extends DaggerFragment {
    @BindView(R.id.typListy)
    TextView typListy;

    @BindView(R.id.lista)
    RecyclerView orderDetailsRecyclerView;

    @Inject
    OrderDetailViewModelFactory orderDetailViewModelFactory;

    private OrderDetailViewModel orderDetailViewModel;

    private LiveData<List<OrderDetail>> orderOrderDetailsLiveData;

    private LiveData<Order> orderLiveData;

    private OrderDetailRecyclerViewAdapter orderDetailRecyclerViewAdapter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("login", MODE_PRIVATE);
        int userId = sharedPreferences.getInt("userId", 0);

        orderDetailViewModel = ViewModelProviders.of(getActivity(), orderDetailViewModelFactory).get(OrderDetailViewModel.class);

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
            calendar.add(Calendar.DATE, 1);
        }
        date = calendar.getTime();
        orderDetailViewModel.initOrder(date, Integer.toString(userId));

        orderLiveData = orderDetailViewModel.getOrder();
        orderDetailRecyclerViewAdapter = new OrderDetailRecyclerViewAdapter(new ArrayList<>());
        orderLiveData.observe(this, (order) -> {
            if (order != null) {
                int orderId = order.getId();
                orderDetailViewModel.initOrRefreshOrderOrderDetailsList(Integer.toString(orderId));
                orderOrderDetailsLiveData = orderDetailViewModel.getOrderOrderDetailsList();
                orderOrderDetailsLiveData.observe(this, (orderDetails) ->
                        orderDetailRecyclerViewAdapter.setList(orderDetails));
            }
        });
        orderDetailViewModel.initOrder(date, Integer.toString(userId));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_view, container, false);
        ButterKnife.bind(this, v);
        typListy = v.findViewById(R.id.typListy);
        typListy.setText("Zamówione produkty");

        orderDetailsRecyclerView.setAdapter(orderDetailRecyclerViewAdapter);
        orderDetailsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

//        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                FragmentTransaction transaction = getParentFragment().getFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container, new UserProductInformationFragment());
//                transaction.addToBackStack(null);
//                transaction.commit();
//
//            }
//        });
        return v;
    }


}
