package com.example.kooperatywalubelska;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class ListaProduktowActivity extends Fragment {
    TextView typListy;
    private ListView lista ;
    String[] produkty = {"Marchewka", "Ogórki", "Rzodkiewka", "Szparagi", "Pietruszka", "Pomidor", "Grzyby", "Czereśnie", "Wiśnie"};


    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.pole_list_product_activity,container, false);
        typListy = v.findViewById(R.id.typListy);
        typListy.setText("Wszystkie produkty");

        lista = v.findViewById(R.id.lista);
        ProductAdapter productAdapter = new com.example.kooperatywalubelska.ProductAdapter(v.getContext(),produkty);
        lista.setAdapter(productAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(),ProductInformationActivity.class);
                startActivity(intent);

            }
        });

        return v;
    }

}
