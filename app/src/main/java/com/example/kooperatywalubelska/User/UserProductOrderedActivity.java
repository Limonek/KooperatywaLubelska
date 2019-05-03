package com.example.kooperatywalubelska.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kooperatywalubelska.Adapters.ProductAdapter;
import com.example.kooperatywalubelska.Administrator.AdministratorEventListActivity;
import com.example.kooperatywalubelska.Administrator.AdministratorProductInformationActivity;
import com.example.kooperatywalubelska.R;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class UserProductOrderedActivity extends Fragment {
    String[] produkty = {"Ogórki", "Szparagi", "Pietruszka", "Wiśnie"};
    String[] dostawca = {"Dostawca 1","Dostawca 2","Dostawca 3","Dostawca 2"};

    TextView typListy;
    private ListView lista ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_activity,container, false);
        typListy =  v.findViewById(R.id.typListy);
        typListy.setText("Zamówione produkty");
        lista = v.findViewById(R.id.lista);
        ProductAdapter productAdapter = new ProductAdapter(v.getContext(),produkty, dostawca);
        lista.setAdapter(productAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentTransaction transaction = getParentFragment().getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new UserProductInformationActivity());
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        return v;
    }


}
