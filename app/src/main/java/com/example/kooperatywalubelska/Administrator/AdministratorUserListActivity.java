package com.example.kooperatywalubelska.Administrator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.kooperatywalubelska.Adapters.ProductAdapter;
import com.example.kooperatywalubelska.R;

public class AdministratorUserListActivity extends Fragment {
    TextView typListy;
    private ListView lista ;
    String[] uzytkownicy = {"AdamMajewski", "NowyDostawca", "MiMaciejewski", "MichalB", "WojtekP", "PawelWojtowicz", "MarekMa", "KasiaCath", "JuliaWronska"};
    String[] dostawca = {"Dostawca 1","Dostawca 2","Dostawca 3","Dostawca 1","Dostawca 2","Dostawca 3","Dostawca 1","Dostawca 2","Dostawca 3"};
    Button addProductButton;

    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_activity,container, false);
        typListy = v.findViewById(R.id.typListy);
        typListy.setText("Użytkownicy");
        addProductButton=v.findViewById(R.id.zapiszButton);
        addProductButton.setText("Dodaj nowego użytkownika");

        lista = v.findViewById(R.id.lista);
        ProductAdapter productAdapter = new ProductAdapter(getContext(),uzytkownicy,dostawca);
        lista.setAdapter(productAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new AdministratorUserInformationActivity());
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new AdministratorUserAddActivity());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return v;
    }
}
