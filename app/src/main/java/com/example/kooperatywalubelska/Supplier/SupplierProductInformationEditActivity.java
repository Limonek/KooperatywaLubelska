package com.example.kooperatywalubelska.Supplier;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kooperatywalubelska.R;

public class SupplierProductInformationEditActivity extends AppCompatActivity {
    TextView nazwaProduktu;
    TextView opisProduktu;
    TextView dostawcaProduktu;
    EditText minIloscEditProduktu;
    Button zapiszButton;
    String nazwa,opis,dostawca,minIlosc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_information_activity);
        nazwaProduktu =  findViewById(R.id.nazwaProduktuText);
        opisProduktu =  findViewById(R.id.opisProduktuText);
        dostawcaProduktu =  findViewById(R.id.dostawcaProduktuText);
        minIloscEditProduktu = findViewById(R.id.minIloscEditText);
        zapiszButton = findViewById(R.id.zapiszButton);
        nazwaProduktu.setVisibility(View.VISIBLE);
        opisProduktu.setVisibility(View.VISIBLE);
        dostawcaProduktu.setVisibility(View.VISIBLE);
        minIloscEditProduktu.setVisibility(View.VISIBLE);
        zapiszButton.setVisibility(View.VISIBLE);
        nazwa = "Marchewka";
        opis = "3kg Marchewki - od lokalnego sprzedawcy znajdującego się na terenie Lubelszczyzny. Najwyższa jakość.";
        dostawca = "Dostawca marchewek";
        minIlosc = "10";
        nazwaProduktu.setText(nazwa);
        opisProduktu.setText(opis);
        dostawcaProduktu.setText(dostawca);
        minIloscEditProduktu.setText(minIlosc);

        zapiszButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //zapis do bazy - przycisk mozna zaprogramowac aby pojawil sie po zmianie wartosci w polu ilosci
            }
        });

    }
}
