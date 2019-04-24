package com.example.kooperatywalubelska.Administrator;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.kooperatywalubelska.Adapters.EventAdapter;
import com.example.kooperatywalubelska.R;

public class AdministratorEventListActivity extends Fragment {
    TextView typListy;
    private ListView lista ;
    private ArrayAdapter<String> adapter ;
    String[] nameEvent = {"Podział produktów styczeń", "Zdrowe żywienie", "Nowi dostawcy", "Podział produktów Luty"};
    String[] dateEvent = {"20-01-2019", "27.01.2019", "3.02.2019", "10.02.2019"};
    String[] discriptionEvent = {"Podział produktów między członkami społeczności kooperatywy", "Rozmowa z dietetykiem o zdrowych produkach w diecie", "Wybór nowych dostawców do kooperatywy", "Podział produktów między członkami społeczności kooperatywy"};
    Button addEvent;
    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_activity,container, false);
        typListy = v.findViewById(R.id.typListy);
        typListy.setText("Wszystkie wydarzenia");
        Button addEvent = v.findViewById(R.id.zapiszButton);
        addEvent.setText("Dodaj nowe wydarzenie");
        lista = v.findViewById(R.id.lista);
        EventAdapter eventAdapter = new EventAdapter(getContext(),nameEvent,dateEvent,discriptionEvent);
        lista.setAdapter(eventAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new AdministratorEventInformationActivity());
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new AdministratorEventAddActivity());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return v;
    }
}
