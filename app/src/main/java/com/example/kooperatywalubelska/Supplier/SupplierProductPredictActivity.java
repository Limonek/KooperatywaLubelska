package com.example.kooperatywalubelska.Supplier;

import android.content.Context;
import android.content.Intent;
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

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SupplierProductPredictActivity extends DaggerFragment {
    @Inject
    Webservice webservice;

    String produkt = "Marchew";
    int product_id=1;
    String miesiac = "05";
   /* String[] rok = {"2019", "2018", "2017", "2016"};
    int[] ilosc = {10,28,19,22};
*/
    Button nextButton;
    Button prevButton;
    TextView nazwaProduktu;
    TextView miesiacPredykcji;
    TextView iloscProduktu;

    String data;

    List<Prediction> lista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.supplier_product_predict_activity,container, false);

        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formate = new SimpleDateFormat("MM");
        StringBuffer sb = new StringBuffer("");
        Date now = calendar.getTime();
        data = formate.format(now);

        nextButton = v.findViewById(R.id.nextButton);
        prevButton = v.findViewById(R.id.poprzedniButton);
        nazwaProduktu = v.findViewById(R.id.productNameEditText);
        miesiacPredykcji = v.findViewById(R.id.monthNameEditText);
        iloscProduktu = v.findViewById(R.id.quantityEditText);

        nazwaProduktu.setText(produkt);
        miesiacPredykcji.setText(String.valueOf(data));

        zapytanieDoBazy(data,product_id);





        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int miesiacLiczba = Integer.parseInt(data);
                miesiacLiczba++;
                if(miesiacLiczba==13) {
                    data="01";
                } else if (miesiacLiczba<10) {
                    data="0"+miesiacLiczba;
                } else  if (miesiacLiczba>9){
                    data=String.valueOf(miesiacLiczba);
                }


                miesiacPredykcji.setText(data);
                zapytanieDoBazy(data,product_id);
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int miesiacLiczba = Integer.parseInt(data);
                miesiacLiczba--;
                if(miesiacLiczba==0) {
                    data="12";
                } else if (miesiacLiczba<10) {
                    data="0"+miesiacLiczba;
                } else  if (miesiacLiczba>9){
                    data=String.valueOf(miesiacLiczba);
                }


                miesiacPredykcji.setText(data);
                zapytanieDoBazy(data,product_id);
            }
        });

     return v;
    }

    public void zapytanieDoBazy(String data, int product_id) {
        iloscProduktu.setText(String.valueOf("..."));
        webservice.getPredictionForProduct(data,product_id).enqueue(new Callback<GsonListDecorator<Prediction>>() {
            @Override
            public void onResponse(Call<GsonListDecorator<Prediction>> call, Response<GsonListDecorator<Prediction>> response) {
                GsonListDecorator<Prediction> entity = response.body();
                lista=entity.getArrayList();
                int n = lista.size();
                double wynik=0;
                int suma=0;
                //int n = lista.size();
                if(n==0) {
                    wynik = 0;
                } else {
                    for (int i = 0; i < n; i++) {
                        suma += lista.get(i).getIlosc();
                    }
                    wynik=suma/n;
                }
                iloscProduktu.setText(String.valueOf(wynik));
            }

            @Override
            public void onFailure(Call<GsonListDecorator<Prediction>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }
}
