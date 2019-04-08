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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kooperatywalubelska.Adapters.ProductAdapter;
import com.example.kooperatywalubelska.R;

public class SupplierMyProductListActivity extends Fragment {
    private ListView lista ;
    String[] produkty = {"Marchewka", "Ogórki", "Rzodkiewka", "Szparagi"};

    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_clear_activity,container, false);

        lista = v.findViewById(R.id.lista);
        ProductAdapter productAdapter = new ProductAdapter(getContext(), produkty);
        lista.setAdapter(productAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new SupplierProductInformationEditActivity());
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        return v;
    }
}
