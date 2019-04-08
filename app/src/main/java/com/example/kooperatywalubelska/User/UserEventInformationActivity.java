package com.example.kooperatywalubelska.User;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kooperatywalubelska.R;

public class UserEventInformationActivity extends Fragment {
    TextView nameEvent;
    TextView dateEvent;
    TextView discriptionEvent;

    String name,data,discription;
    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.event_information_activity,container, false);
        nameEvent = v.findViewById(R.id.nameEventText);
        dateEvent = v.findViewById(R.id.dataEventText);
        discriptionEvent = v.findViewById(R.id.discriptionEventText);
        nameEvent.setVisibility(View.VISIBLE);
        dateEvent.setVisibility(View.VISIBLE);
        discriptionEvent.setVisibility(View.VISIBLE);
        name ="nazwa wydarzenia";
        data = "Data wydarzenia";
        discription = "opis wydarzenia";
        nameEvent.setText(name);
        dateEvent.setText(data);
        discriptionEvent.setText(discription);

        return v;
    }
}
