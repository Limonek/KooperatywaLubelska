package com.example.kooperatywalubelska.User;

import android.os.Bundle;

import com.example.kooperatywalubelska.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTabHost;

public class UserProductFragmentsActivity extends AppCompatActivity {
    FragmentTabHost tabHost;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);
        tabHost=findViewById(R.id.tabHost);
        tabHost.setup(this,getSupportFragmentManager(), android.R.id.tabcontent);
        tabHost.addTab(tabHost.newTabSpec("zamowione").setIndicator("Zamówione"), UserProductOrderedFragment.class,null);
        tabHost.addTab(tabHost.newTabSpec("wszystkie").setIndicator("Wszystkie"), UserProductListActivity.class,null);
        tabHost.addTab(tabHost.newTabSpec("niezamowione").setIndicator("Nie zamówione"), UserProductNotOrderedActivity.class,null);

    }
}
