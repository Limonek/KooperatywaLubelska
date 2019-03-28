package com.example.kooperatywalubelska.Supplier;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kooperatywalubelska.Adapters.OrdersAdapter;
import com.example.kooperatywalubelska.Adapters.ProductOrderAdapter;
import com.example.kooperatywalubelska.R;

public class SupplierAllOrdersActivity extends AppCompatActivity {
    private ListView lista ;
    String[] datyZamowienia = {"20.01.2019", "27.01.2019", "03.02.29019", "11.02.2019","19.02.2019","25.02.2019"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_clear_activity);

        lista = findViewById(R.id.lista);
        OrdersAdapter ordersAdapter = new OrdersAdapter(getApplicationContext(), datyZamowienia);
        lista.setAdapter(ordersAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), SupplierCurrencyOrderActivity.class);
                startActivity(intent);

            }
        });
    }
}
