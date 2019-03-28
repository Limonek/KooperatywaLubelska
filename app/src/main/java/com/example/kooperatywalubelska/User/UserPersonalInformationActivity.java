package com.example.kooperatywalubelska.User;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kooperatywalubelska.R;

public class UserPersonalInformationActivity  extends AppCompatActivity {
    TextView nameText;
    TextView lastNameText;
    TextView dateOfBirthText;
    TextView addressText;
    TextView emailText;
    TextView phoneText;
    Button edytujButton;

    String name,lastName,dateOfBirth,address,email,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_information_activity);
        nameText = findViewById(R.id.nameText);
        lastNameText = findViewById(R.id.lastNameText);
        dateOfBirthText = findViewById(R.id.dateOfBirthText);
        addressText = findViewById(R.id.addressText);
        emailText = findViewById(R.id.emailText);
        phoneText = findViewById(R.id.phoneText);
        edytujButton = findViewById(R.id.zapiszButton);
        edytujButton.setText("Edytuj");
        nameText.setVisibility(View.VISIBLE);
        lastNameText.setVisibility(View.VISIBLE);
        dateOfBirthText.setVisibility(View.VISIBLE);
        addressText.setVisibility(View.VISIBLE);
        emailText.setVisibility(View.VISIBLE);
        phoneText.setVisibility(View.VISIBLE);
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
                Intent intent = new Intent(getApplicationContext(),UserPersonalInformationEditActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("lastName",lastName);
                intent.putExtra("dateOfBirth",dateOfBirth);
                intent.putExtra("address",address);
                intent.putExtra("email",email);
                intent.putExtra("phone",phone);
                startActivity(intent);
            }
        });
    }
}
