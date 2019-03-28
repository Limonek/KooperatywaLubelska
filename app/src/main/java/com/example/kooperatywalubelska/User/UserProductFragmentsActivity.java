package com.example.kooperatywalubelska.User;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;

import com.example.kooperatywalubelska.R;

public class UserProductFragmentsActivity extends AppCompatActivity {
    FragmentTabHost tabHost;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);
        tabHost=findViewById(R.id.tabHost);
        tabHost.setup(this,getSupportFragmentManager(), android.R.id.tabcontent);
        tabHost.addTab(tabHost.newTabSpec("zamowione").setIndicator("Zamówione"), UserProductOrderedActivity.class,null);
        tabHost.addTab(tabHost.newTabSpec("wszystkie").setIndicator("Wszystkie"), UserProductListActivity.class,null);
        tabHost.addTab(tabHost.newTabSpec("niezamowione").setIndicator("Nie zamówione"), UserProductNotOrderedActivity.class,null);

    }
}
