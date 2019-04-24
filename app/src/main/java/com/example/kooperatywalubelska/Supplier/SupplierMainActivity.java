package com.example.kooperatywalubelska.Supplier;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kooperatywalubelska.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class SupplierMainActivity extends Fragment {

    Button myProduct;
    Button currentOrder;
    Button allOrders;
    @Nullable
    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.supplier_main_activity,container, false);
        myProduct = v.findViewById(R.id.myProductButton);
        currentOrder = v.findViewById(R.id.currentOrderButton);
        allOrders = v.findViewById(R.id.allOrdersButton);

        myProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new SupplierMyProductListActivity());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        currentOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new SupplierCurrencyOrderActivity());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        allOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new SupplierAllOrdersActivity());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        return v;
    }
}
