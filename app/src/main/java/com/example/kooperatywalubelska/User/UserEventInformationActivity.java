package com.example.kooperatywalubelska.User;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.kooperatywalubelska.R;

public class UserEventInformationActivity extends AppCompatActivity {
    TextView nameEvent;
    TextView dateEvent;
    TextView discriptionEvent;

    String name,data,discription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_information_activity);
        nameEvent = findViewById(R.id.nameEventText);
        dateEvent = findViewById(R.id.dataEventText);
        discriptionEvent = findViewById(R.id.discriptionEventText);
        nameEvent.setVisibility(View.VISIBLE);
        dateEvent.setVisibility(View.VISIBLE);
        discriptionEvent.setVisibility(View.VISIBLE);
        name = getIntent().getStringExtra("name");
        data = getIntent().getStringExtra("date");
        discription = getIntent().getStringExtra("discription");
        nameEvent.setText(name);
        dateEvent.setText(data);
        discriptionEvent.setText(discription);
    }
}
