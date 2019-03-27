package com.example.kooperatywalubelska;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ProductInformationActivity extends AppCompatActivity {
TextView nazwaProduktu;
TextView opisProduktu;
TextView dostawcaProduktu;
TextView minIloscProduktu;

String nazwa,opis,dostawca,minIlosc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_information_activity);
        nazwaProduktu =  findViewById(R.id.nazwaProduktuText);
        opisProduktu =  findViewById(R.id.opisProduktuText);
        dostawcaProduktu =  findViewById(R.id.dostawcaProduktuText);
        minIloscProduktu = findViewById(R.id.minIloscProduktuText);
        nazwa = "Marchewka";
        opis = "3kg Marchewki - od lokalnego sprzedawcy znajdującego się na terenie Lubelszczyzny. Najwyższa jakość.";
        dostawca = "Dostawca marchewek";
        minIlosc = "10";
        nazwaProduktu.setText(nazwa);
        opisProduktu.setText(opis);
        dostawcaProduktu.setText(dostawca);
        minIloscProduktu.setText(minIlosc);

    }
}
