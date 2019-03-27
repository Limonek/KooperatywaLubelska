package com.example.kooperatywalubelska;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;

public class WydarzeniaListaActivity extends AppCompatActivity {
    FragmentTabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list_activity);
        tabHost=findViewById(R.id.tabHost);
        tabHost.setup(this,getSupportFragmentManager(), android.R.id.tabcontent);
        tabHost.addTab(tabHost.newTabSpec("wszystkie").setIndicator("Wszystkie"), WszystkieWydarzeniaActivity.class,null);
        tabHost.addTab(tabHost.newTabSpec("zadeklarowane").setIndicator("Zadeklarowane"), ZadeklarowaneWydarzeniaActivity.class,null);

    }
}
