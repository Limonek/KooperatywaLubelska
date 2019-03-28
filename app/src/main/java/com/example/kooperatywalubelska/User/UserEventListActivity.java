package com.example.kooperatywalubelska.User;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;

import com.example.kooperatywalubelska.R;

public class UserEventListActivity extends AppCompatActivity {
    FragmentTabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);
        tabHost=findViewById(R.id.tabHost);
        tabHost.setup(this,getSupportFragmentManager(), android.R.id.tabcontent);
        tabHost.addTab(tabHost.newTabSpec("wszystkie").setIndicator("Wszystkie"), UserEventsAllActivity.class,null);
        tabHost.addTab(tabHost.newTabSpec("zadeklarowane").setIndicator("Zadeklarowane"), UserEventDeclaredActivity.class,null);

    }
}
