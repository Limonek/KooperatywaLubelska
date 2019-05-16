package com.example.kooperatywalubelska.User;

//import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.kooperatywalubelska.R;
import com.example.kooperatywalubelska.Webservice;
import com.example.kooperatywalubelska.database.User;
import com.example.kooperatywalubelska.database.User2;
import com.example.kooperatywalubelska.database.UserName;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class UserPersonalInformationFragment extends DaggerFragment {
    @Inject
    Webservice webservice;

    TextView nameText;
    TextView lastNameText;
    TextView addressText;
    TextView emailText;
    TextView phoneText;
    Button edytujButton;
    EditText addressEditText;
    EditText emailEditText;
    EditText phoneEditText;
    Button zapiszButton;

    String name,lastName,address,email,phone;
    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_information_activity,container, false);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("login", MODE_PRIVATE);
        int userId = sharedPreferences.getInt("userId", 0);

        nameText = v.findViewById(R.id.nameText);
        lastNameText = v.findViewById(R.id.lastNameText);
        addressText = v.findViewById(R.id.addressText);
        emailText = v.findViewById(R.id.emailTextt);
        phoneText = v.findViewById(R.id.phoneText);
        edytujButton = v.findViewById(R.id.edytujButton);
        addressEditText = v.findViewById(R.id.addressEditText);
        emailEditText = v.findViewById(R.id.emailEditText);
        phoneEditText = v.findViewById(R.id.phoneEditText);
        zapiszButton = v.findViewById(R.id.zapiszButton);
        nameText.setVisibility(View.VISIBLE);
        lastNameText.setVisibility(View.VISIBLE);
        addressText.setVisibility(View.VISIBLE);
        emailText.setVisibility(View.VISIBLE);
        phoneText.setVisibility(View.VISIBLE);

        webservice.getUserDetail(userId).enqueue(new Callback<User2>() {
            @Override
            public void onResponse(Call<User2> call, Response<User2> response) {
                User2 entity=response.body();
                nameText.setText(entity.getFirstName());
                lastNameText.setText(entity.getLastName());
                addressText.setText(entity.getAddress());
                emailText.setText(entity.getEmail());
                phoneText.setText(entity.getPhone());
            }

            @Override
            public void onFailure(Call<User2> call, Throwable t) {

            }
        });

        webservice.getUserName(userId).enqueue(new Callback<UserName>() {
            @Override
            public void onResponse(Call<UserName> call, Response<UserName> response) {
                UserName entity=response.body();
                nameText.setText(entity.getFirstName());
            }

            @Override
            public void onFailure(Call<UserName> call, Throwable t) {

            }
        });
        //pobranie danych z bazy
        /*name="Katarzyna";
        lastName="La";
        dateOfBirth="02-03-1995";
        address="Nadbystrzycka 23";
        email="kl@wp.pl";
        phone="123456123";*/

        /*nameText.setText(name);
        lastNameText.setText(lastName);
        addressText.setText(address);
        emailText.setText(email);
        phoneText.setText(phone);
*/
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
                addressEditText.setText(addressText.getText());
                emailEditText.setText(emailText.getText());
                phoneEditText.setText(phoneText.getText());
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
