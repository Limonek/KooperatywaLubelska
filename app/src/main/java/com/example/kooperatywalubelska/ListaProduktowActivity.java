package com.example.kooperatywalubelska;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class ListaProduktowActivity extends Fragment {
    TextView typListy;
    private ListView lista ;
    private ArrayAdapter<String> adapter ;
    String[] produkty = {"Marchewka", "Ogórki", "Rzodkiewka", "Szparagi", "Pietruszka", "Pomidor", "Grzyby", "Czereśnie", "Wiśnie"};


    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.pole_list_product_activity,container, false);
        typListy = (TextView) v.findViewById(R.id.typListy);
        typListy.setText("Wszystkie produkty");

        lista = (ListView) v.findViewById(R.id.lista);
        ProductAdapter productAdapter = new com.example.kooperatywalubelska.ProductAdapter(v.getContext(),produkty);
        lista.setAdapter(productAdapter);
        return v;
    }

}
