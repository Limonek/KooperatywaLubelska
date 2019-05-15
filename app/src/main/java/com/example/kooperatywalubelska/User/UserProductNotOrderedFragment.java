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
import com.example.kooperatywalubelska.database.OrderDetailDao;
import com.example.kooperatywalubelska.database.Product;
import com.example.kooperatywalubelska.viewmodels.OrderDetailViewModel;
import com.example.kooperatywalubelska.viewmodels.ProductViewModel;
import com.example.kooperatywalubelska.viewmodels.ProductViewModelFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;

import static android.content.Context.MODE_PRIVATE;

public class UserProductNotOrderedFragment extends DaggerFragment {

    @BindView(R.id.typListy)
    TextView typListy;

    @BindView(R.id.lista)
    RecyclerView notOrderedProductsRecyclerView;

    @Inject
    ProductViewModelFactory productViewModelFactory;

    @Inject
    ProductViewModelFactory orderDetailViewModelFactory;

    private ProductViewModel productViewModel;
    private OrderDetailViewModel orderDetailViewModel;
    LiveData<Order> orderLiveData;
    private LiveData<List<Product>> notOrderedProductsLiveData;

    @Inject
    OrderDetailDao orderDetailDao;

    private ProductRecyclerViewAdapter productRecyclerViewAdapter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        productViewModel = ViewModelProviders.of(getActivity(), productViewModelFactory).get(ProductViewModel.class);
        productViewModel.initNotOrderedProductsList();

        orderDetailViewModel = ViewModelProviders.of(getActivity(), orderDetailViewModelFactory).get(OrderDetailViewModel.class);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("login", MODE_PRIVATE);
        int userId = sharedPreferences.getInt("userId", 0);

//        orderDetailViewModel.initOrder(date, Integer.toString(userId));

        orderLiveData = orderDetailViewModel.getOrder();
        orderLiveData.observe(this, (order) -> {
            productRecyclerViewAdapter.setOrderId(order.getId());
        });
        if(orderLiveData.getValue()!=null) {
            productRecyclerViewAdapter.setOrderId(orderLiveData.getValue().getId());
        }
        notOrderedProductsLiveData = productViewModel.getNotOrderedProductsList();

        productRecyclerViewAdapter = new ProductRecyclerViewAdapter(new ArrayList<>(), orderDetailDao);

        notOrderedProductsLiveData.observe(this, (products) ->
                productRecyclerViewAdapter.setList(products));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_view, container, false);
        ButterKnife.bind(this, v);
        typListy.setText("Niezamówione produkty");

        notOrderedProductsRecyclerView.setAdapter(productRecyclerViewAdapter);
        notOrderedProductsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



//        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                FragmentTransaction transaction = getParentFragment().getFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container,new UserProductInformationFragment());
//                transaction.addToBackStack(null);
//                transaction.commit();
//
//            }
//        });
        return v;
    }
}