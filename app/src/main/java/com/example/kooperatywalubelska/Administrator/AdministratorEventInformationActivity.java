package com.example.kooperatywalubelska.Administrator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kooperatywalubelska.R;

public class AdministratorEventInformationActivity extends AppCompatActivity {
    TextView nameEvent;
    TextView dateEvent;
    TextView discriptionEvent;
    Button edytujButton;
    String name,data,discription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_information_activity);
        nameEvent = findViewById(R.id.nameEventText);
        dateEvent = findViewById(R.id.dataEventText);
        discriptionEvent = findViewById(R.id.discriptionEventText);
        edytujButton = findViewById(R.id.joinToEventButton);
        edytujButton.setText("Edytuj");
        nameEvent.setVisibility(View.VISIBLE);
        dateEvent.setVisibility(View.VISIBLE);
        discriptionEvent.setVisibility(View.VISIBLE);
        name = getIntent().getStringExtra("name");
        data = getIntent().getStringExtra("date");
        discription = getIntent().getStringExtra("discription");
        nameEvent.setText(name);
        dateEvent.setText(data);
        discriptionEvent.setText(discription);

        edytujButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdministratorEventInformationEditActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("date",data);
                intent.putExtra("discription",discription);
                startActivity(intent);

            }
        });
    }
}
