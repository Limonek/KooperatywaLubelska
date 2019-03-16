package com.example.kooperatywalubelska;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;

public class ProductListActivity extends AppCompatActivity {
    FragmentTabHost tabHost;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list_activity);
        tabHost=(FragmentTabHost)findViewById(R.id.tabHost);
        tabHost.setup(this,getSupportFragmentManager(), android.R.id.tabcontent);
        tabHost.addTab(tabHost.newTabSpec("zamowione").setIndicator("Zamówione"), ZamowienieActivity.class,null);
        tabHost.addTab(tabHost.newTabSpec("wszystkie").setIndicator("Wszystkie"), ListaProduktowActivity.class,null);
        tabHost.addTab(tabHost.newTabSpec("niezamowione").setIndicator("Nie zamówione"), NieZamowieoneActivity.class,null);

    }
}
