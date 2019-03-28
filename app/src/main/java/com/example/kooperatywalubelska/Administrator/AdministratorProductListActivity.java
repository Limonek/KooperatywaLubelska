package com.example.kooperatywalubelska.Administrator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kooperatywalubelska.Adapters.ProductAdapter;
import com.example.kooperatywalubelska.R;

public class AdministratorProductListActivity extends AppCompatActivity {
    TextView typListy;
    private ListView lista ;
    String[] produkty = {"Marchewka", "Ogórki", "Rzodkiewka", "Szparagi", "Pietruszka", "Pomidor", "Grzyby", "Czereśnie", "Wiśnie"};
    Button addProductButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        typListy = findViewById(R.id.typListy);
        typListy.setText("Wszystkie produkty");
        addProductButton=findViewById(R.id.zapiszButton);
        addProductButton.setText("Dodaj nowy produkt");

        lista = findViewById(R.id.lista);
        ProductAdapter productAdapter = new ProductAdapter(getApplicationContext(),produkty);
        lista.setAdapter(productAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),AdministrationProductInformationActivity.class);
                startActivity(intent);

            }
        });

        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdministratorProductAddActivity.class);
                startActivity(intent);
            }
        });
    }
}
