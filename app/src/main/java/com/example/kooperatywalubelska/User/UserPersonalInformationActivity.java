package com.example.kooperatywalubelska.User;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kooperatywalubelska.R;

public class UserPersonalInformationActivity  extends Fragment {
    TextView nameText;
    TextView lastNameText;
    TextView dateOfBirthText;
    TextView addressText;
    TextView emailText;
    TextView phoneText;
    Button edytujButton;
    EditText addressEditText;
    EditText emailEditText;
    EditText phoneEditText;
    Button zapiszButton;

    String name,lastName,dateOfBirth,address,email,phone;
    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_information_activity,container, false);
        nameText = v.findViewById(R.id.nameText);
        lastNameText = v.findViewById(R.id.lastNameText);
        dateOfBirthText = v.findViewById(R.id.dateOfBirthText);
        addressText = v.findViewById(R.id.addressText);
        emailText = v.findViewById(R.id.emailText);
        phoneText = v.findViewById(R.id.phoneText);
        edytujButton = v.findViewById(R.id.edytujButton);
        addressEditText = v.findViewById(R.id.addressEditText);
        emailEditText = v.findViewById(R.id.emailEditText);
        phoneEditText = v.findViewById(R.id.phoneEditText);
        zapiszButton = v.findViewById(R.id.zapiszButton);
        nameText.setVisibility(View.VISIBLE);
        lastNameText.setVisibility(View.VISIBLE);
        dateOfBirthText.setVisibility(View.VISIBLE);
        addressText.setVisibility(View.VISIBLE);
        emailText.setVisibility(View.VISIBLE);
        phoneText.setVisibility(View.VISIBLE);

        //pobranie danych z bazy
        name="Katarzyna";
        lastName="La";
        dateOfBirth="02-03-1995";
        address="Nadbystrzycka 23";
        email="kl@wp.pl";
        phone="123456123";

        nameText.setText(name);
        lastNameText.setText(lastName);
        dateOfBirthText.setText(dateOfBirth);
        addressText.setText(address);
        emailText.setText(email);
        phoneText.setText(phone);

        edytujButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addressText.setVisibility(View.INVISIBLE);
                emailText.setVisibility(View.INVISIBLE);
                phoneText.setVisibility(View.INVISIBLE);
                edytujButton.setVisibility(View.INVISIBLE);
                addressEditText.setVisibility(View.VISIBLE);
                emailEditText.setVisibility(View.VISIBLE);
                phoneEditText.setVisibility(View.VISIBLE);
                zapiszButton.setVisibility(View.VISIBLE);
                addressEditText.setText(address);
                emailEditText.setText(email);
                phoneEditText.setText(phone);
            }
        });
        zapiszButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addressEditText.setVisibility(View.INVISIBLE);
                emailEditText.setVisibility(View.INVISIBLE);
                phoneEditText.setVisibility(View.INVISIBLE);
                zapiszButton.setVisibility(View.INVISIBLE);
                addressText.setVisibility(View.VISIBLE);
                emailText.setVisibility(View.VISIBLE);
                phoneText.setVisibility(View.VISIBLE);
                edytujButton.setVisibility(View.VISIBLE);
                addressText.setText(addressEditText.getText());
                emailText.setText(emailEditText.getText());
                phoneText.setText(phoneEditText.getText());

                //zapis do bazy
            }
        });

        return v;
    }
}
