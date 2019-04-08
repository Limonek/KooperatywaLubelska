package com.example.kooperatywalubelska.User;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kooperatywalubelska.Administrator.AdministratorMainActivity;
import com.example.kooperatywalubelska.R;
import com.example.kooperatywalubelska.Supplier.SupplierMainActivity;

public class UserMainActivity extends Fragment {
    Button zamowienia;
    Button wydarzenia;
    Button listaProduktow;

    @Nullable
    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_main_activity,container, false);
        zamowienia = v.findViewById(R.id.zamowieniaButton);
        wydarzenia = v.findViewById(R.id.wydarzeniaButton);
        listaProduktow = v.findViewById(R.id.listaProduktowButton);

        zamowienia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),UserProductFragmentsActivity.class);
                startActivity(intent);
            }
        });
        wydarzenia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),UserEventListActivity.class);
                startActivity(intent);
            }
        });
        listaProduktow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),UserProductFragmentsActivity.class);
                startActivity(intent);
            }
        });


        return v;
    }
}
