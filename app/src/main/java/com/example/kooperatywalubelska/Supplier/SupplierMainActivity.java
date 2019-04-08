package com.example.kooperatywalubelska.Supplier;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kooperatywalubelska.Administrator.AdministratorMainActivity;
import com.example.kooperatywalubelska.Administrator.AdministratorProductListActivity;
import com.example.kooperatywalubelska.R;
import com.example.kooperatywalubelska.User.UserMainActivity;

public class SupplierMainActivity extends Fragment{

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
