package com.example.kooperatywalubelska.User;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kooperatywalubelska.Administrator.AdministratorMainActivity;
import com.example.kooperatywalubelska.R;
import com.example.kooperatywalubelska.Supplier.SupplierMainActivity;

public class UserMainActivity extends AppCompatActivity {
    Button zamowienia;
    Button wydarzenia;
    Button listaProduktow;

    Button admin;
    Button supp;
    Button profil;
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
                Intent intent = new Intent(getApplicationContext(),UserProductFragmentsActivity.class);
                startActivity(intent);
            }
        });
        wydarzenia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),UserEventListActivity.class);
                startActivity(intent);
            }
        });
        listaProduktow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),UserProductFragmentsActivity.class);
                startActivity(intent);
            }
        });


        admin = findViewById(R.id.adminTryb);
        supp = findViewById(R.id.supplierTryb);
        profil = findViewById(R.id.personal);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdministratorMainActivity.class);
                startActivity(intent);
            }
        });
        supp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SupplierMainActivity.class);
                startActivity(intent);
            }
        });
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),UserPersonalInformationActivity.class);
                startActivity(intent);
            }
        });
    }
}
