package com.example.kooperatywalubelska.Administrator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kooperatywalubelska.R;

public class AdministratorEventInformationEditActivity extends AppCompatActivity {
    TextView nameEventEdit;
    TextView dateEventEdit;
    TextView discriptionEventEdit;
    Button zapiszButton;
    String name, data, discription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_information_activity);
        nameEventEdit = findViewById(R.id.nazwaWydarzeniaEditText);
        dateEventEdit = findViewById(R.id.dataEditText);
        discriptionEventEdit = findViewById(R.id.opisEditText);
        zapiszButton = findViewById(R.id.joinToEventButton);
        zapiszButton.setText("Zapisz");
        nameEventEdit.setVisibility(View.VISIBLE);
        dateEventEdit.setVisibility(View.VISIBLE);
        discriptionEventEdit.setVisibility(View.VISIBLE);
        name = getIntent().getStringExtra("name");
        data = getIntent().getStringExtra("date");
        discription = getIntent().getStringExtra("discription");
        nameEventEdit.setText(name);
        dateEventEdit.setText(data);
        discriptionEventEdit.setText(discription);

        zapiszButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //obsluga zapisu
            }
        });
    }
}
