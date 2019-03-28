package com.example.kooperatywalubelska.Administrator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.kooperatywalubelska.R;
import com.example.kooperatywalubelska.Supplier.SupplierMainActivity;
import com.example.kooperatywalubelska.User.UserMainActivity;

public class AdministratorMainActivity extends AppCompatActivity {
    Button supp;
    Button user;


    Button productEdit;
    Button userEdit;
    Button eventEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administrator_main_activity);
        productEdit = findViewById(R.id.productEditButton);
        userEdit = findViewById(R.id.userEditButton);
        eventEdit = findViewById(R.id.eventEditButton);

        productEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdministratorProductListActivity.class);
                startActivity(intent);
            }
        });
        userEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdministratorUserListActivity.class);
                startActivity(intent);
            }
        });
        eventEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdministratorEventListActivity.class);
                startActivity(intent);
            }
        });

        user = findViewById(R.id.userTryb);
        supp = findViewById(R.id.supplierTryb);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),UserMainActivity.class);
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
    }
}
