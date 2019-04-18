package com.example.kooperatywalubelska.Administrator;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kooperatywalubelska.R;

public class AdministratorProductAddActivity extends Fragment {

    EditText nazwaProduktuEdit;
    EditText opisProduktuEdit;
    EditText dostawcaProduktuEdit;
    EditText minIloscProduktuEdit;

    Button zapiszButton;
    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.product_information_activity,container, false);

        nazwaProduktuEdit =  v.findViewById(R.id.productEditText);
        opisProduktuEdit =  v.findViewById(R.id.opisEditText);
        dostawcaProduktuEdit =  v.findViewById(R.id.dostawcaEditText);
        minIloscProduktuEdit = v.findViewById(R.id.minIloscEditText);
        zapiszButton = v.findViewById(R.id.zapiszButton);

        nazwaProduktuEdit.setVisibility(View.VISIBLE);
        opisProduktuEdit.setVisibility(View.VISIBLE);
        dostawcaProduktuEdit.setVisibility(View.VISIBLE);
        minIloscProduktuEdit.setVisibility(View.VISIBLE);
        zapiszButton.setVisibility(View.VISIBLE);

        zapiszButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //zapis do bazy
            }
        });

        return v;
    }

}
