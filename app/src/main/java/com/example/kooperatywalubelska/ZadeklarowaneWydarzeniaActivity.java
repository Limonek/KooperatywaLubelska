package com.example.kooperatywalubelska;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ZadeklarowaneWydarzeniaActivity extends Fragment {
    TextView typListy;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.pole_list_product_activity, container, false);
        typListy = (TextView) v.findViewById(R.id.typListy);
        typListy.setText("Zadeklarowane wydarzenia");
        return v;
    }
}