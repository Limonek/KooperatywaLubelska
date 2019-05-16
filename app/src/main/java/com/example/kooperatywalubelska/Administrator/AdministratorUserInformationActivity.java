package com.example.kooperatywalubelska.Administrator;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.kooperatywalubelska.R;

public class AdministratorUserInformationActivity extends Fragment {
    TextView nameText;
    TextView lastNameText;
    TextView dateOfBirthText;
    TextView addressText;
    TextView emailText;
    TextView phoneText;
    Button edytujButton;

    EditText nameEditText;
    EditText lastNameEditText;
    EditText dateOfBirthEditText;
    EditText addressEditText;
    EditText emailEditText;
    EditText phoneEditText;
    Button zapiszButton;

    String name, lastName, dateOfBirth, address, email, phone;

    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_information_activity,container, false);
        nameText = v.findViewById(R.id.nameText);
        lastNameText = v.findViewById(R.id.lastNameText);
        addressText = v.findViewById(R.id.addressText);
        emailText = v.findViewById(R.id.emailTextt);
        phoneText = v.findViewById(R.id.phoneText);
        edytujButton = v.findViewById(R.id.edytujButton);
        nameText.setVisibility(View.VISIBLE);
        lastNameText.setVisibility(View.VISIBLE);
        addressText.setVisibility(View.VISIBLE);
        emailText.setVisibility(View.VISIBLE);
        phoneText.setVisibility(View.VISIBLE);
        nameEditText = v.findViewById(R.id.nameEditText);
        lastNameEditText = v.findViewById(R.id.lastNameEditText);
        addressEditText = v.findViewById(R.id.addressEditText);
        emailEditText = v.findViewById(R.id.emailEditText);
        phoneEditText = v.findViewById(R.id.phoneEditText);
        zapiszButton = v.findViewById(R.id.zapiszButton);

        name = "Katarzyna";
        lastName = "La";
        dateOfBirth = "02-03-1995";
        address = "Nadbystrzycka 23";
        email = "kl@wp.pl";
        phone = "123456123";

        nameText.setText(name);
        lastNameText.setText(lastName);
        addressText.setText(address);
        emailText.setText(email);
        phoneText.setText(phone);

        edytujButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameEditText.setVisibility(View.VISIBLE);
                lastNameEditText.setVisibility(View.VISIBLE);
                addressEditText.setVisibility(View.VISIBLE);
                emailEditText.setVisibility(View.VISIBLE);
                phoneEditText.setVisibility(View.VISIBLE);
                zapiszButton.setVisibility(View.VISIBLE);

                nameEditText.setText(nameText.getText());
                lastNameEditText.setText(lastNameText.getText());
                addressEditText.setText(addressText.getText());
                emailEditText.setText(emailText.getText());
                phoneEditText.setText(phoneText.getText());

                nameText.setVisibility(View.INVISIBLE);
                lastNameText.setVisibility(View.INVISIBLE);
                addressText.setVisibility(View.INVISIBLE);
                emailText.setVisibility(View.INVISIBLE);
                phoneText.setVisibility(View.INVISIBLE);
                edytujButton.setVisibility(View.INVISIBLE);

            }
        });

        zapiszButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameEditText.setVisibility(View.INVISIBLE);
                lastNameEditText.setVisibility(View.INVISIBLE);
                addressEditText.setVisibility(View.INVISIBLE);
                emailEditText.setVisibility(View.INVISIBLE);
                phoneEditText.setVisibility(View.INVISIBLE);
                zapiszButton.setVisibility(View.INVISIBLE);

                nameText.setText(nameEditText.getText());
                lastNameText.setText(lastNameEditText.getText());
                addressText.setText(addressEditText.getText());
                emailText.setText(emailEditText.getText());
                phoneText.setText(phoneEditText.getText());

                nameText.setVisibility(View.VISIBLE);
                lastNameText.setVisibility(View.VISIBLE);
                addressText.setVisibility(View.VISIBLE);
                emailText.setVisibility(View.VISIBLE);
                phoneText.setVisibility(View.VISIBLE);
                edytujButton.setVisibility(View.VISIBLE);

                //zapis do bazy
            }
        });
        return v;
    }
}