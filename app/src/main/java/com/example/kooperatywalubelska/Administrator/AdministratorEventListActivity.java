package com.example.kooperatywalubelska.Administrator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kooperatywalubelska.Adapters.EventAdapter;
import com.example.kooperatywalubelska.R;

public class AdministratorEventListActivity extends AppCompatActivity {
    TextView typListy;
    private ListView lista ;
    private ArrayAdapter<String> adapter ;
    String[] nameEvent = {"Podział produktów styczeń", "Zdrowe żywienie", "Nowi dostawcy", "Podział produktów Luty"};
    String[] dateEvent = {"20-01-2019", "27.01.2019", "3.02.2019", "10.02.2019"};
    String[] discriptionEvent = {"Podział produktów między członkami społeczności kooperatywy", "Rozmowa z dietetykiem o zdrowych produkach w diecie", "Wybór nowych dostawców do kooperatywy", "Podział produktów między członkami społeczności kooperatywy"};
    Button addEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        typListy = findViewById(R.id.typListy);
        typListy.setText("Wszystkie wydarzenia");
        Button addEvent = findViewById(R.id.zapiszButton);
        addEvent.setText("Dodaj nowe wydarzenie");
        lista = findViewById(R.id.lista);
        EventAdapter eventAdapter = new EventAdapter(getApplicationContext(),nameEvent,dateEvent,discriptionEvent);
        lista.setAdapter(eventAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),AdministratorEventInformationActivity.class);
                intent.putExtra("name",nameEvent[i]);
                intent.putExtra("date",dateEvent[i]);
                intent.putExtra("discription",discriptionEvent[i]);
                startActivity(intent);

            }
        });

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdministratorEventAddActivity.class);
                startActivity(intent);
            }
        });
    }
}
