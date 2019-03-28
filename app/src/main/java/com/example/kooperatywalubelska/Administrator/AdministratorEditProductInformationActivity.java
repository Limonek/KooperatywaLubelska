package com.example.kooperatywalubelska.Administrator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kooperatywalubelska.R;

public class AdministratorEditProductInformationActivity extends AppCompatActivity {
    EditText nazwaProduktu;
    EditText opisProduktu;
    EditText dostawcaProduktu;
    EditText minIloscProduktu;

    Button edytujButton;
    String nazwa, opis, dostawca, minIlosc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_information_activity);
        nazwaProduktu = findViewById(R.id.productEditText);
        opisProduktu = findViewById(R.id.opisEditText);
        dostawcaProduktu = findViewById(R.id.dostawcaEditText);
        minIloscProduktu = findViewById(R.id.minIloscEditText);
        edytujButton = findViewById(R.id.zapiszButton);
        edytujButton.setVisibility(View.VISIBLE);
        nazwaProduktu.setVisibility(View.VISIBLE);
        opisProduktu.setVisibility(View.VISIBLE);
        dostawcaProduktu.setVisibility(View.VISIBLE);
        minIloscProduktu.setVisibility(View.VISIBLE);
        nazwa = getIntent().getStringExtra("name");
        opis = getIntent().getStringExtra("discription");
        dostawca = getIntent().getStringExtra("supplier");
        minIlosc = getIntent().getStringExtra("minIlosc");
        nazwaProduktu.setText(nazwa);
        opisProduktu.setText(opis);
        dostawcaProduktu.setText(dostawca);
        minIloscProduktu.setText(minIlosc);

        edytujButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //zapisz button
            }
        });
    }
}
