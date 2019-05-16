package com.example.kooperatywalubelska.User;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kooperatywalubelska.Administrator.AdministratorMain;
import com.example.kooperatywalubelska.R;
import com.example.kooperatywalubelska.Supplier.SupplierMain;
import com.example.kooperatywalubelska.Webservice;
import com.example.kooperatywalubelska.database.Supplier;
import com.example.kooperatywalubelska.database.User;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends DaggerAppCompatActivity {
    @Inject
    Webservice webservice;

    EditText loginEditText;
    EditText passwordEditText;
    Button loginButton;

    String login, password;

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

                webservice.getLoginUser(login,password).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User entity = response.body();
                        if(entity.isAdministrator()) {
                            SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                            sharedPreferences.edit().putInt("userId", entity.getId()).commit();
                            Intent intent = new Intent(getApplicationContext(), AdministratorMain.class);
                            intent.putExtra("id_user", entity.getId());
                            /*intent.putExtra("lastName", entity.getLastName());
                            intent.putExtra("email", entity.getEmail());*/
                            startActivity(intent);
                        } else if(entity.isSupplier()) {
                            SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                            sharedPreferences.edit().putInt("userId", entity.getId()).commit();
                            Intent intent = new Intent(getApplicationContext(), SupplierMain.class);
                            startActivity(intent);
                        } else if(entity.getId()!=0){
                            //loginEditText.setText(entity.getLastName());
                            SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                            sharedPreferences.edit().putInt("userId", entity.getId()).commit();
                            Intent intent = new Intent(getApplicationContext(), UserMain.class);
                            startActivity(intent);
                        } else {
                            passwordEditText.setText("nie dziala");
                        }


                        //temporar solution - no login
                        //SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                        //sharedPreferences.edit().putInt("userId", Integer.parseInt(login)).commit();

                        //sprawdzenie w bazie i wtedy trzeba wybrac czy uzytkownik jest adminem, userem, czy supplier i wlaczyc odpowiednie Activity

                        //Intent intent = new Intent(getApplicationContext(), UserMain.class);
                        //intent.putExtra("login", login); //mozna wykorzystac pozniej w klasie jako nazwa uzytkownika w MainActivity
                        //startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        loginEditText.setText("nie nie");
                    }
                });


                /*
                //temporar solution - no login
                SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                sharedPreferences.edit().putInt("userId", Integer.parseInt(login)).commit();

                //sprawdzenie w bazie i wtedy trzeba wybrac czy uzytkownik jest adminem, userem, czy supplier i wlaczyc odpowiednie Activity

                Intent intent = new Intent(getApplicationContext(), UserMain.class);
                intent.putExtra("login", login); //mozna wykorzystac pozniej w klasie jako nazwa uzytkownika w MainActivity
                startActivity(intent);
*/
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
