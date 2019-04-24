package com.example.kooperatywalubelska.Supplier;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.kooperatywalubelska.R;

public class SupplierProductInformationEditActivity extends Fragment {
    TextView nazwaProduktu;
    TextView opisProduktu;
    TextView dostawcaProduktu;
    TextView minIloscProduktu;
    EditText minIloscEditProduktu;
    Button zapiszButton, edytujButton;
    String nazwa,opis,dostawca,minIlosc;
    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.product_information_activity,container, false);
        nazwaProduktu =  v.findViewById(R.id.nazwaProduktuText);
        opisProduktu =  v.findViewById(R.id.opisProduktuText);
        dostawcaProduktu =  v.findViewById(R.id.dostawcaProduktuText);
        minIloscEditProduktu = v.findViewById(R.id.minIloscEditText);
        minIloscProduktu = v.findViewById(R.id.minIloscProduktuText);
        edytujButton = v.findViewById(R.id.edytujButton);
        zapiszButton = v.findViewById(R.id.zapiszButton);
        nazwaProduktu.setVisibility(View.VISIBLE);
        opisProduktu.setVisibility(View.VISIBLE);
        dostawcaProduktu.setVisibility(View.VISIBLE);
        minIloscProduktu.setVisibility(View.VISIBLE);
        minIloscEditProduktu.setVisibility(View.INVISIBLE);
        edytujButton.setVisibility(View.VISIBLE);
        zapiszButton.setVisibility(View.INVISIBLE);
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
                minIloscEditProduktu.setText(minIloscProduktu.getText());
                minIloscProduktu.setVisibility(View.INVISIBLE);
                edytujButton.setVisibility(View.INVISIBLE);
                minIloscEditProduktu.setVisibility(View.VISIBLE);
                zapiszButton.setVisibility(View.VISIBLE);
            }
        });
        zapiszButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minIloscProduktu.setText(minIloscEditProduktu.getText());
                minIloscProduktu.setVisibility(View.VISIBLE);
                edytujButton.setVisibility(View.VISIBLE);
                minIloscEditProduktu.setVisibility(View.INVISIBLE);
                zapiszButton.setVisibility(View.INVISIBLE);
                //zapis do bazy - przycisk mozna zaprogramowac aby pojawil sie po zmianie wartosci w polu ilosci
            }
        });
        return v;
    }
}
