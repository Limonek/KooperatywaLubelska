package com.example.kooperatywalubelska.Administrator;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kooperatywalubelska.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class AdministratorMainActivity extends Fragment {

    Button productEdit;
    Button userEdit;
    Button eventEdit;
    @Nullable
    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.administrator_main_activity,container, false);
        productEdit = v.findViewById(R.id.productEditButton);
        userEdit = v.findViewById(R.id.userEditButton);
        eventEdit = v.findViewById(R.id.eventEditButton);

        productEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new AdministratorProductListActivity());
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        userEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new AdministratorUserListActivity());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        eventEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new AdministratorEventListActivity());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return v;
    }
}
