package com.example.kooperatywalubelska;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserMainActivity extends AppCompatActivity {
    Button zamowienia;
    Button wydarzenia;
    Button listaProduktow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main_activity);
        zamowienia = findViewById(R.id.zamowieniaButton);
        wydarzenia = findViewById(R.id.wydarzeniaButton);
        listaProduktow = findViewById(R.id.listaProduktowButton);

        zamowienia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ProductListActivity.class);
                startActivity(intent);
            }
        });
        wydarzenia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),WydarzeniaListaActivity.class);
                startActivity(intent);
            }
        });
        listaProduktow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ProductListActivity.class);
                startActivity(intent);
            }
        });
    }
}
