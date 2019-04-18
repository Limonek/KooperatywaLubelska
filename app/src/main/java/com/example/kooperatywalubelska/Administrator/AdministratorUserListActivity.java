package com.example.kooperatywalubelska.Administrator;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kooperatywalubelska.Adapters.ProductAdapter;
import com.example.kooperatywalubelska.R;

public class AdministratorUserListActivity extends Fragment {
    TextView typListy;
    private ListView lista ;
    String[] uzytkownicy = {"AdamMajewski", "NowyDostawca", "MiMaciejewski", "MichalB", "WojtekP", "PawelWojtowicz", "MarekMa", "KasiaCath", "JuliaWronska"};
    Button addProductButton;

    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_activity,container, false);
        typListy = v.findViewById(R.id.typListy);
        typListy.setText("Użytkownicy");
        addProductButton=v.findViewById(R.id.zapiszButton);
        addProductButton.setText("Dodaj nowego użytkownika");

        lista = v.findViewById(R.id.lista);
        ProductAdapter productAdapter = new ProductAdapter(getContext(),uzytkownicy);
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
