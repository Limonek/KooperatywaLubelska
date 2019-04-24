package com.example.kooperatywalubelska.User;


//import android.app.FragmentTransaction;
//import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kooperatywalubelska.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new com.example.kooperatywalubelska.User.UserProductFragmentsListActivity());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        wydarzenia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new com.example.kooperatywalubelska.User.UserEventListActivity());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        listaProduktow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new com.example.kooperatywalubelska.User.UserProductFragmentsListActivity());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        return v;
    }
}
