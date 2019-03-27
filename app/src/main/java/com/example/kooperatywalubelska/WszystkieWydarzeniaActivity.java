package com.example.kooperatywalubelska;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class WszystkieWydarzeniaActivity extends Fragment {
    TextView typListy;
    private ListView lista ;
    private ArrayAdapter<String> adapter ;
    String[] nameEvent = {"Podział produktów styczeń", "Zdrowe żywienie", "Nowi dostawcy", "Podział produktów Luty"};
    String[] dateEvent = {"20-01-2019", "27.01.2019", "3.02.2019", "10.02.2019"};
    String[] discriptionEvent = {"Podział produktów między członkami społeczności kooperatywy", "Rozmowa z dietetykiem o zdrowych produkach w diecie", "Wybór nowych dostawców do kooperatywy", "Podział produktów między członkami społeczności kooperatywy"};

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
