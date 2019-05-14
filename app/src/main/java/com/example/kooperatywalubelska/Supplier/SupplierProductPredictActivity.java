package com.example.kooperatywalubelska.Supplier;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import com.example.kooperatywalubelska.R;
import com.example.kooperatywalubelska.Webservice;
import com.example.kooperatywalubelska.database.GsonListDecorator;
import com.example.kooperatywalubelska.database.Prediction;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SupplierProductPredictActivity extends DaggerFragment {
    @Inject
    Webservice webservice;

    String produkt = "Marchew";
    String miesiac = "maj";
    String[] rok = {"2019", "2018", "2017", "2016"};
    int[] ilosc = {10,28,19,22};

    Button nextButton;
    TextView nazwaProduktu;
    TextView miesiacPredykcji;
    TextView iloscProduktu;

    List<Prediction> lista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.supplier_product_predict_activity,container, false);

        webservice.getPredictionForProduct("05",1).enqueue(
                new Callback<GsonListDecorator<Prediction>>() {

                    @Override
                    public void onResponse(Call<GsonListDecorator<Prediction>> call, Response<GsonListDecorator<Prediction>> response) {
                        GsonListDecorator<Prediction> entity = response.body();
                        //entity.setLastRefresh(new Date());
                        SupplierProductPredictActivity.this.lista=entity.getArrayList();

                        Log.e("TAG", "DATA REQUEST " + call.request().toString());
                    }

                    @Override
                    public void onFailure(Call<GsonListDecorator<Prediction>> call, Throwable t) {
                        Log.e("TAG", "Call<Order>: " + call.toString());
                        Log.e("TAG", "Request: " + call.request().toString());
                        Log.e("TAG", "Request.body: " + call.request().body());
                        Log.e("TAG", "Throwable: " + t.toString());
                    }
                });





        nextButton = v.findViewById(R.id.nextButton);
        nazwaProduktu = v.findViewById(R.id.productNameEditText);
        miesiacPredykcji = v.findViewById(R.id.monthNameEditText);
        iloscProduktu = v.findViewById(R.id.quantityEditText);
        int suma=0;
        int n = rok.length;
        for(int i =0;i<n;i++) {
            suma+=ilosc[i];
        }

        nazwaProduktu.setText(produkt);
        miesiacPredykcji.setText(miesiac);
        iloscProduktu.setText(String.valueOf(suma/n));

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //wlaczenie tego samego widoku ale z innymi danymi
            }
        });

     return v;
    }
}
