package com.example.kooperatywalubelska.Supplier;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kooperatywalubelska.Adapters.ProductOrderAdapter;
import com.example.kooperatywalubelska.R;

public class SupplierCurrencyOrderActivity extends AppCompatActivity {
    private ListView lista ;
    String[] produkty = {"Marchewka", "Ogórki", "Rzodkiewka", "Szparagi"};
    String[] ilosc = {"4","6","2","1"};
    String data = "11.02.2019";
    TextView tytul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_clear_activity);
        tytul = findViewById(R.id.tytulText);
        tytul.setVisibility(View.VISIBLE);
        tytul.setText("Data zamówienia: "+data);
        lista = findViewById(R.id.lista);
        ProductOrderAdapter productOrderAdapter = new ProductOrderAdapter(getApplicationContext(), produkty, ilosc);
        lista.setAdapter(productOrderAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), SupplierProductInformationEditActivity.class);
                startActivity(intent);

            }
        });
    }
}
