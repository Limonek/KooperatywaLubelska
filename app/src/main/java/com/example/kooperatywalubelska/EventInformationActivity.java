package com.example.kooperatywalubelska;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class EventInformationActivity extends AppCompatActivity {
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
        name = getIntent().getStringExtra("name");
        data = getIntent().getStringExtra("date");
        discription = getIntent().getStringExtra("discription");
        nameEvent.setText(name);
        dateEvent.setText(data);
        discriptionEvent.setText(discription);
    }
}
