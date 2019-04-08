package com.example.kooperatywalubelska.Supplier;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kooperatywalubelska.Adapters.OrdersAdapter;
import com.example.kooperatywalubelska.Adapters.ProductOrderAdapter;
import com.example.kooperatywalubelska.R;

public class SupplierAllOrdersActivity extends Fragment {
    private ListView lista ;
    String[] datyZamowienia = {"20.01.2019", "27.01.2019", "03.02.29019", "11.02.2019","19.02.2019","25.02.2019"};

    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_clear_activity,container, false);

        lista = v.findViewById(R.id.lista);
        OrdersAdapter ordersAdapter = new OrdersAdapter(getContext(), datyZamowienia);
        lista.setAdapter(ordersAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new SupplierCurrencyOrderActivity());
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        return v;
    }
}
