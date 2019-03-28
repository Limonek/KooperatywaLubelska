package com.example.kooperatywalubelska.Administrator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kooperatywalubelska.R;

public class AdministratorProductAddActivity extends AppCompatActivity {

    EditText nazwaProduktuEdit;
    EditText opisProduktuEdit;
    EditText dostawcaProduktuEdit;
    EditText minIloscProduktuEdit;

    Button zapiszButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_information_activity);

        nazwaProduktuEdit =  findViewById(R.id.productEditText);
        opisProduktuEdit =  findViewById(R.id.opisEditText);
        dostawcaProduktuEdit =  findViewById(R.id.dostawcaEditText);
        minIloscProduktuEdit = findViewById(R.id.minIloscEditText);
        zapiszButton = findViewById(R.id.zapiszButton);

        nazwaProduktuEdit.setVisibility(View.VISIBLE);
        opisProduktuEdit.setVisibility(View.VISIBLE);
        dostawcaProduktuEdit.setVisibility(View.VISIBLE);
        minIloscProduktuEdit.setVisibility(View.VISIBLE);
        zapiszButton.setVisibility(View.VISIBLE);


    }

}
