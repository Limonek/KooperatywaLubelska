package com.example.kooperatywalubelska.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kooperatywalubelska.Administrator.AdministratorMain;
import com.example.kooperatywalubelska.R;
import com.example.kooperatywalubelska.Supplier.SupplierMain;

public class LoginActivity extends AppCompatActivity {
    EditText loginEditText;
    EditText passwordEditText;
    Button loginButton;

    String login,password;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        loginEditText = findViewById(R.id.loginEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login = loginEditText.getText().toString();
                password = passwordEditText.getText().toString();

                //sprawdzenie w bazie i wtedy trzeba wybrac czy uzytkownik jest adminem, userem, czy supplier i wlaczyc odpowiednie Activity

                Intent intent = new Intent(getApplicationContext(),UserMain.class);
                intent.putExtra("login",login); //mozna wykorzystac pozniej w klasie jako nazwa uzytkownika w MainActivity
                startActivity(intent);

                /* dla Admina
                Intent intent = new Intent(getApplicationContext(),AdministratorMain.class);
                intent.putExtra("login",login); //mozna wykorzystac pozniej w klasie jako nazwa uzytkownika w MainActivity
                startActivity(intent);

                Intent intent = new Intent(getApplicationContext(),SupplierMain.class);
                intent.putExtra("login",login); //mozna wykorzystac pozniej w klasie jako nazwa uzytkownika w MainActivity
                startActivity(intent);

                 */
            }
        });

    }



}
