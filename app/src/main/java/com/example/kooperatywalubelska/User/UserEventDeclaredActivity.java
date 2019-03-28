package com.example.kooperatywalubelska.User;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kooperatywalubelska.Adapters.EventAdapter;
import com.example.kooperatywalubelska.R;

public class UserEventDeclaredActivity extends Fragment {
    private ListView lista ;
    String[] nameEvent = {"Podział produktów styczeń",  "Nowi dostawcy"};
    String[] dateEvent = {"20-01-2019", "3.02.2019"};
    String[] discriptionEvent = {"Podział produktów między członkami społeczności kooperatywy", "Wybór nowych dostawców do kooperatywy"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_clear_activity,container, false);

        lista = v.findViewById(R.id.lista);
        EventAdapter eventAdapter = new EventAdapter(v.getContext(),nameEvent,dateEvent,discriptionEvent);
        lista.setAdapter(eventAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(),UserEventInformationActivity.class);
                intent.putExtra("name",nameEvent[i]);
                intent.putExtra("date",dateEvent[i]);
                intent.putExtra("discription",discriptionEvent[i]);
                startActivity(intent);

            }
        });
        return v;
    }
}