package com.example.kooperatywalubelska.Administrator;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.kooperatywalubelska.R;

public class AdministratorEventInformationActivity extends Fragment {
    TextView nameEvent;
    TextView dateEvent;
    TextView discriptionEvent;
    Button edytujButton;

    TextView nameEventEdit;
    TextView dateEventEdit;
    TextView discriptionEventEdit;
    Button zapiszButton;
    String name,data,discription;
    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.event_information_activity,container, false);
        nameEvent = v.findViewById(R.id.nameEventText);
        dateEvent = v.findViewById(R.id.dataEventText);
        discriptionEvent = v.findViewById(R.id.discriptionEventText);
        edytujButton = v.findViewById(R.id.joinToEventButton);
        edytujButton.setText("Edytuj");
        nameEvent.setVisibility(View.VISIBLE);
        dateEvent.setVisibility(View.VISIBLE);
        discriptionEvent.setVisibility(View.VISIBLE);
        nameEventEdit = v.findViewById(R.id.nazwaWydarzeniaEditText);
        dateEventEdit = v.findViewById(R.id.dataEditText);
        discriptionEventEdit = v.findViewById(R.id.opisEditText);
        zapiszButton = v.findViewById(R.id.zapiszButton);
        name = "nazwa wydarzenia";
        data = "data wydarzenia";
        discription = "discription";
        nameEvent.setText(name);
        dateEvent.setText(data);
        discriptionEvent.setText(discription);

        edytujButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nameEventEdit.setVisibility(View.VISIBLE);
                dateEventEdit.setVisibility(View.VISIBLE);
                discriptionEventEdit.setVisibility(View.VISIBLE);
                zapiszButton.setVisibility(View.VISIBLE);

                nameEventEdit.setText(nameEvent.getText());
                dateEventEdit.setText(dateEvent.getText());
                discriptionEventEdit.setText(discriptionEvent.getText());

                nameEvent.setVisibility(View.INVISIBLE);
                dateEvent.setVisibility(View.INVISIBLE);
                discriptionEvent.setVisibility(View.INVISIBLE);
                edytujButton.setVisibility(View.INVISIBLE);

            }
        });

        zapiszButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nameEventEdit.setVisibility(View.INVISIBLE);
                dateEventEdit.setVisibility(View.INVISIBLE);
                discriptionEventEdit.setVisibility(View.INVISIBLE);
                zapiszButton.setVisibility(View.INVISIBLE);

                nameEvent.setText(nameEventEdit.getText());
                dateEvent.setText(dateEventEdit.getText());
                discriptionEvent.setText(discriptionEventEdit.getText());

                nameEvent.setVisibility(View.VISIBLE);
                dateEvent.setVisibility(View.VISIBLE);
                discriptionEvent.setVisibility(View.VISIBLE);
                edytujButton.setVisibility(View.VISIBLE);

            }
        });

        return v;
    }
}
