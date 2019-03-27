package com.example.kooperatywalubelska;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AdministratorMainActivity extends AppCompatActivity {
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
                Intent intent = new Intent(getApplicationContext(),ProductListActivity.class);
                startActivity(intent);
            }
        });
        userEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),WydarzeniaListaActivity.class);
                startActivity(intent);
            }
        });
        eventEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ProductListActivity.class);
                startActivity(intent);
            }
        });
    }
}
