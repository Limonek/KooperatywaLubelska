package com.example.kooperatywalubelska.Supplier;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.kooperatywalubelska.Administrator.AdministratorMainActivity;
import com.example.kooperatywalubelska.R;
import com.example.kooperatywalubelska.User.UserMainActivity;

public class SupplierMainActivity extends AppCompatActivity {
    Button admin;
    Button user;

    Button myProduct;
    Button currentOrder;
    Button allOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supplier_main_activity);
        myProduct = findViewById(R.id.myProductButton);
        currentOrder = findViewById(R.id.currentOrderButton);
        allOrders = findViewById(R.id.allOrdersButton);

        myProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SupplierMyProductListActivity.class);
                startActivity(intent);
            }
        });
        currentOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SupplierCurrencyOrderActivity.class);
                startActivity(intent);
            }
        });
        allOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SupplierAllOrdersActivity.class);
                startActivity(intent);
            }
        });



        user = findViewById(R.id.userTryb);
        admin = findViewById(R.id.adminTryb);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),UserMainActivity.class);
                startActivity(intent);
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdministratorMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
