package com.example.kooperatywalubelska.Supplier;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import com.example.kooperatywalubelska.R;

public class SupplierProductPredictActivity extends Fragment {
    String produkt = "Marchew";
    String miesiac = "maj";
    String[] rok = {"2019", "2018", "2017", "2016"};
    int[] ilosc = {10,28,19,22};

    Button nextButton;
    TextView nazwaProduktu;
    TextView miesiacPredykcji;
    TextView iloscProduktu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.supplier_product_predict_activity,container, false);

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
