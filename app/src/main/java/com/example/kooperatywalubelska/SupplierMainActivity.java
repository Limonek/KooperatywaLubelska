package com.example.kooperatywalubelska;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SupplierMainActivity extends AppCompatActivity {
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
                Intent intent = new Intent(getApplicationContext(),ProductListActivity.class);
                startActivity(intent);
            }
        });
        currentOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),WydarzeniaListaActivity.class);
                startActivity(intent);
            }
        });
        allOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ProductListActivity.class);
                startActivity(intent);
            }
        });
    }
}
