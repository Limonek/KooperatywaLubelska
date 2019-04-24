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

public class AdministratorProductListActivity extends Fragment {
    TextView typListy;
    private ListView lista ;
    String[] produkty = {"Marchewka", "Ogórki", "Rzodkiewka", "Szparagi", "Pietruszka", "Pomidor", "Grzyby", "Czereśnie", "Wiśnie"};
    Button addProductButton;

    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_activity,container, false);
        typListy = v.findViewById(R.id.typListy);
        typListy.setText("Wszystkie produkty");
        addProductButton=v.findViewById(R.id.zapiszButton);
        addProductButton.setText("Dodaj nowy produkt");

        lista = v.findViewById(R.id.lista);
        ProductAdapter productAdapter = new ProductAdapter(getContext(),produkty);
        lista.setAdapter(productAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new AdministratorProductInformationActivity());
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new AdministratorProductAddActivity());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    return v;
    }


}
