package com.example.kooperatywalubelska.Administrator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.kooperatywalubelska.R;

public class AdministratorProductInformationActivity extends Fragment {
    TextView nazwaProduktu;
    TextView opisProduktu;
    TextView dostawcaProduktu;
    TextView minIloscProduktu;

    EditText nazwaEditProduktu;
    EditText opisEditProduktu;
    EditText dostawcaEditProduktu;
    EditText minIloscEditProduktu;

    Button edytujButton;
    Button zapiszButton;
    String nazwa,opis,dostawca,minIlosc;
    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.product_information_activity,container, false);
        nazwaProduktu =  v.findViewById(R.id.nazwaProduktuText);
        opisProduktu =  v.findViewById(R.id.opisProduktuText);
        dostawcaProduktu =  v.findViewById(R.id.dostawcaProduktuText);
        minIloscProduktu = v.findViewById(R.id.minIloscProduktuText);
        edytujButton = v.findViewById(R.id.edytujButton);
        nazwaProduktu.setVisibility(View.VISIBLE);
        opisProduktu.setVisibility(View.VISIBLE);
        dostawcaProduktu.setVisibility(View.VISIBLE);
        minIloscProduktu.setVisibility(View.VISIBLE);
        edytujButton.setVisibility(View.VISIBLE);

        nazwaEditProduktu = v.findViewById(R.id.productEditText);
        opisEditProduktu = v.findViewById(R.id.opisEditText);
        dostawcaEditProduktu = v.findViewById(R.id.dostawcaEditText);
        minIloscEditProduktu = v.findViewById(R.id.minIloscEditText);
        zapiszButton = v.findViewById(R.id.zapiszButton);

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

                zapiszButton.setVisibility(View.VISIBLE);
                nazwaEditProduktu.setVisibility(View.VISIBLE);
                opisEditProduktu.setVisibility(View.VISIBLE);
                dostawcaEditProduktu.setVisibility(View.VISIBLE);
                minIloscEditProduktu.setVisibility(View.VISIBLE);

                nazwaEditProduktu.setText(nazwaProduktu.getText());
                opisEditProduktu.setText(opisProduktu.getText());
                dostawcaEditProduktu.setText(dostawcaProduktu.getText());
                minIloscEditProduktu.setText(minIloscProduktu.getText());

                opisProduktu.setText("");

                edytujButton.setVisibility(View.INVISIBLE);
                nazwaProduktu.setVisibility(View.INVISIBLE);
                opisProduktu.setVisibility(View.INVISIBLE);
                dostawcaProduktu.setVisibility(View.INVISIBLE);
                minIloscProduktu.setVisibility(View.INVISIBLE);
            }
        });

        zapiszButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zapiszButton.setVisibility(View.INVISIBLE);
                nazwaEditProduktu.setVisibility(View.INVISIBLE);
                opisEditProduktu.setVisibility(View.INVISIBLE);
                dostawcaEditProduktu.setVisibility(View.INVISIBLE);
                minIloscEditProduktu.setVisibility(View.INVISIBLE);

                nazwaProduktu.setText(nazwaEditProduktu.getText());
                opisProduktu.setText(opisEditProduktu.getText());
                dostawcaProduktu.setText(dostawcaEditProduktu.getText());
                minIloscProduktu.setText(minIloscEditProduktu.getText());

                edytujButton.setVisibility(View.VISIBLE);
                nazwaProduktu.setVisibility(View.VISIBLE);
                opisProduktu.setVisibility(View.VISIBLE);
                dostawcaProduktu.setVisibility(View.VISIBLE);
                minIloscProduktu.setVisibility(View.VISIBLE);

                //zapis do bazy
            }
        });
        return v;
    }
}
