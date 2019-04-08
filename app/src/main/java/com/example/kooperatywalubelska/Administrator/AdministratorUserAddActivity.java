package com.example.kooperatywalubelska.Administrator;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.kooperatywalubelska.R;

public class AdministratorUserAddActivity extends Fragment {
    EditText nameEditText;
    EditText lastNameEditText;
    EditText dateOfBirthEditText;
    EditText addressEditText;
    EditText emailEditText;
    EditText phoneEditText;
    Button zapiszButton;

    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_information_activity,container, false);
        nameEditText = v.findViewById(R.id.nameEditText);
        lastNameEditText = v.findViewById(R.id.lastNameEditText);
        dateOfBirthEditText = v.findViewById(R.id.dateOfBirthEditText);
        addressEditText = v.findViewById(R.id.addressEditText);
        emailEditText = v.findViewById(R.id.emailEditText);
        phoneEditText = v.findViewById(R.id.phoneEditText);
        zapiszButton = v.findViewById(R.id.zapiszButton);
        nameEditText.setVisibility(View.VISIBLE);
        lastNameEditText.setVisibility(View.VISIBLE);
        dateOfBirthEditText.setVisibility(View.VISIBLE);
        addressEditText.setVisibility(View.VISIBLE);
        emailEditText.setVisibility(View.VISIBLE);
        phoneEditText.setVisibility(View.VISIBLE);


        zapiszButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //zapis
            }
        });

        return v;
    }
}