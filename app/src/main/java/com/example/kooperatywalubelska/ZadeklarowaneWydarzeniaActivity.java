package com.example.kooperatywalubelska;

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

public class ZadeklarowaneWydarzeniaActivity extends Fragment {
    TextView typListy;
    private ListView lista ;
    String[] nameEvent = {"Podział produktów styczeń",  "Nowi dostawcy"};
    String[] dateEvent = {"20-01-2019", "3.02.2019"};
    String[] discriptionEvent = {"Podział produktów między członkami społeczności kooperatywy", "Wybór nowych dostawców do kooperatywy"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.pole_list_product_activity,container, false);
        typListy = v.findViewById(R.id.typListy);
        typListy.setText("Wszystkie wydarzenia");
        Button zapisz = v.findViewById(R.id.zapiszButton);
        zapisz.setVisibility(View.INVISIBLE);

        lista = v.findViewById(R.id.lista);
        EventAdapter eventAdapter = new EventAdapter(v.getContext(),nameEvent,dateEvent,discriptionEvent);
        lista.setAdapter(eventAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(),EventInformationActivity.class);
                intent.putExtra("name",nameEvent[i]);
                intent.putExtra("date",dateEvent[i]);
                intent.putExtra("discription",discriptionEvent[i]);
                startActivity(intent);

            }
        });
        return v;
    }
}