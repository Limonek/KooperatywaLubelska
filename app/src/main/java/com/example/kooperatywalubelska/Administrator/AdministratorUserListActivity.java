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

public class AdministratorUserListActivity extends AppCompatActivity {
    TextView typListy;
    private ListView lista ;
    String[] uzytkownicy = {"AdamMajewski", "NowyDostawca", "MiMaciejewski", "MichalB", "WojtekP", "PawelWojtowicz", "MarekMa", "KasiaCath", "JuliaWronska"};
    Button addProductButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        typListy = findViewById(R.id.typListy);
        typListy.setText("Użytkownicy");
        addProductButton=findViewById(R.id.zapiszButton);
        addProductButton.setText("Dodaj nowego użytkownika");

        lista = findViewById(R.id.lista);
        ProductAdapter productAdapter = new ProductAdapter(getApplicationContext(),uzytkownicy);
        lista.setAdapter(productAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),AdministratorUserInformationActivity.class);
                startActivity(intent);

            }
        });

        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdministratorUserAddActivity.class);
                startActivity(intent);
            }
        });
    }
}
