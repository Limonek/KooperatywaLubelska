package com.example.kooperatywalubelska.Administrator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kooperatywalubelska.R;

public class AdministrationProductInformationActivity  extends AppCompatActivity {
    TextView nazwaProduktu;
    TextView opisProduktu;
    TextView dostawcaProduktu;
    TextView minIloscProduktu;

    Button edytujButton;
    String nazwa,opis,dostawca,minIlosc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_information_activity);
        nazwaProduktu =  findViewById(R.id.nazwaProduktuText);
        opisProduktu =  findViewById(R.id.opisProduktuText);
        dostawcaProduktu =  findViewById(R.id.dostawcaProduktuText);
        minIloscProduktu = findViewById(R.id.minIloscProduktuText);
        edytujButton = findViewById(R.id.zapiszButton);
        nazwaProduktu.setVisibility(View.VISIBLE);
        opisProduktu.setVisibility(View.VISIBLE);
        dostawcaProduktu.setVisibility(View.VISIBLE);
        minIloscProduktu.setVisibility(View.VISIBLE);
        edytujButton.setVisibility(View.VISIBLE);
        edytujButton.setText("Edytuj");
        nazwa = "Marchewka";
        opis = "3kg Marchewki - od lokalnego sprzedawcy znajdującego się na terenie Lubelszczyzny. Najwyższa jakość.";
        dostawca = "Dostawca marchewek";
        minIlosc = "10";
        nazwaProduktu.setText(nazwa);
        opisProduktu.setText(opis);
        dostawcaProduktu.setText(dostawca);
        minIloscProduktu.setText(minIlosc);

        edytujButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdministratorEditProductInformationActivity.class);
                intent.putExtra("name",nazwa);
                intent.putExtra("discription",opis);
                intent.putExtra("supplier",dostawca);
                intent.putExtra("minIlosc",minIlosc);
                startActivity(intent);
            }
        });
    }
}
