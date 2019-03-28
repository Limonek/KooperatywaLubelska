package com.example.kooperatywalubelska.User;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kooperatywalubelska.R;

public class UserPersonalInformationEditActivity extends AppCompatActivity {
    TextView nameText;
    TextView lastNameText;
    TextView dateOfBirthText;
    EditText addressEditText;
    EditText emailEditText;
    EditText phoneEditText;
    Button zapiszButton;

    String name,lastName,dateOfBirth,address,email,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_information_activity);
        nameText = findViewById(R.id.nameText);
        lastNameText = findViewById(R.id.lastNameText);
        dateOfBirthText = findViewById(R.id.dateOfBirthText);
        addressEditText = findViewById(R.id.addressEditText);
        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        zapiszButton = findViewById(R.id.zapiszButton);
        nameText.setVisibility(View.VISIBLE);
        lastNameText.setVisibility(View.VISIBLE);
        dateOfBirthText.setVisibility(View.VISIBLE);
        addressEditText.setVisibility(View.VISIBLE);
        emailEditText.setVisibility(View.VISIBLE);
        phoneEditText.setVisibility(View.VISIBLE);
        name= getIntent().getStringExtra("name");
        lastName= getIntent().getStringExtra("lastName");
        dateOfBirth= getIntent().getStringExtra("dateOfBirth");
        address= getIntent().getStringExtra("address");
        email= getIntent().getStringExtra("email");
        phone= getIntent().getStringExtra("phone");

        nameText.setText(name);
        lastNameText.setText(lastName);
        dateOfBirthText.setText(dateOfBirth);
        addressEditText.setText(address);
        emailEditText.setText(email);
        phoneEditText.setText(phone);

        zapiszButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //zapis
            }
        });
    }
}
