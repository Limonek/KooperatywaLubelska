package com.example.kooperatywalubelska;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class ZamowienieActivity extends Fragment {
    String[] produkty = {"Ogórki", "Szparagi", "Pietruszka", "Wiśnie"};

    TextView typListy;
    private ListView lista ;
    private ArrayAdapter<String> adapter ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.pole_list_product_activity,container, false);
        lista = (ListView) v.findViewById(R.id.lista);
        ProductAdapter productAdapter = new ProductAdapter(v.getContext(),produkty);
        lista.setAdapter(productAdapter);

        return v;
    }


}
