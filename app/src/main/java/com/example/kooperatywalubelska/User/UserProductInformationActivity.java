package com.example.kooperatywalubelska.User;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.kooperatywalubelska.R;

public class UserProductInformationActivity extends Fragment {
TextView nazwaProduktu;
TextView opisProduktu;
TextView dostawcaProduktu;
TextView minIloscProduktu;

String nazwa,opis,dostawca,minIlosc;
    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.product_information_activity,container, false);
        nazwaProduktu =  v.findViewById(R.id.nazwaProduktuText);
        opisProduktu =  v.findViewById(R.id.opisProduktuText);
        dostawcaProduktu =  v.findViewById(R.id.dostawcaProduktuText);
        minIloscProduktu = v.findViewById(R.id.minIloscProduktuText);
        nazwaProduktu.setVisibility(View.VISIBLE);
        opisProduktu.setVisibility(View.VISIBLE);
        dostawcaProduktu.setVisibility(View.VISIBLE);
        minIloscProduktu.setVisibility(View.VISIBLE);
        nazwa = "Marchewka";
        opis = "3kg Marchewki - od lokalnego sprzedawcy znajdującego się na terenie Lubelszczyzny. Najwyższa jakość.";
        dostawca = "Dostawca marchewek";
        minIlosc = "10";
        nazwaProduktu.setText(nazwa);
        opisProduktu.setText(opis);
        dostawcaProduktu.setText(dostawca);
        minIloscProduktu.setText(minIlosc);

        return v;
    }
}
