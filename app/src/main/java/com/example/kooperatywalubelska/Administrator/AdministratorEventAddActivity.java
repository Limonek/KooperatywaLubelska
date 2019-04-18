package com.example.kooperatywalubelska.Administrator;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.kooperatywalubelska.R;

public class AdministratorEventAddActivity extends Fragment {
    TextView nameEventEdit;
    TextView dateEventEdit;
    TextView discriptionEventEdit;
    Button zapiszButton;
    String name, data, discription;

    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.event_information_activity,container, false);
        nameEventEdit = v.findViewById(R.id.nazwaWydarzeniaEditText);
        dateEventEdit = v.findViewById(R.id.dataEditText);
        discriptionEventEdit = v.findViewById(R.id.opisEditText);
        zapiszButton = v.findViewById(R.id.joinToEventButton);
        zapiszButton.setText("Zapisz");
        nameEventEdit.setVisibility(View.VISIBLE);
        dateEventEdit.setVisibility(View.VISIBLE);
        discriptionEventEdit.setVisibility(View.VISIBLE);

        zapiszButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //obsluga zapisu
            }
        });
        return v;
    }
}