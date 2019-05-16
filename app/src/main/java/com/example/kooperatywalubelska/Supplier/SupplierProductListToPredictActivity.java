package com.example.kooperatywalubelska.Supplier;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.kooperatywalubelska.Adapters.ProductAdapter;
import com.example.kooperatywalubelska.Adapters.ProductAdapter2;
import com.example.kooperatywalubelska.R;
import com.example.kooperatywalubelska.Webservice;
import com.example.kooperatywalubelska.database.GsonListDecorator;
import com.example.kooperatywalubelska.database.Prediction;
import com.example.kooperatywalubelska.database.Product;
import com.example.kooperatywalubelska.database.Supplier;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SupplierProductListToPredictActivity extends DaggerFragment {
    @Inject
    Webservice webservice;
    int user_id=1;
    private ListView lista ;
    String[] produkty={"Marchewka", "Ogórki", "Rzodkiewka", "Szparagi"};
    int[] id_produktu;
    TextView a;

    List<Product> listaProduktow;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_activity,container, false);

        lista = v.findViewById(R.id.lista);
        ProductAdapter2 productAdapter = new ProductAdapter2(getContext(), produkty);
        lista.setAdapter(productAdapter);
        /*a=v.findViewById(R.id.typListy);


        webservice.getProductForSupplierPrediction(1).enqueue(new Callback<GsonListDecorator<Product>>() {
            @Override
            public void onResponse(Call<GsonListDecorator<Product>> call, Response<GsonListDecorator<Product>> response) {
                a.setText("dziala");
            }

            @Override
            public void onFailure(Call<GsonListDecorator<Product>> call, Throwable t) {
                a.setText("nie dziala");
            }
        });
*/

       /* webservice.getProductForSupplierPrediction(1).enqueue(new Callback<GsonListDecorator<Product>>() {
            @Override
            public void onResponse(Call<GsonListDecorator<Product>> call, Response<GsonListDecorator<Product>> response) {
                GsonListDecorator<Product> entity = response.body();
                listaProduktow=entity.getArrayList();
                int n=listaProduktow.size();
                a.setText("ilosc produktow: "+n);*/
                /*if(n!=0) {
                    for(int i=0;i<n;i++) {
                        produkty[i]=listaProduktow.get(i).getName();
                        id_produktu[i]=listaProduktow.get(i).getId();
                    }
                    ProductAdapter2 productAdapter = new ProductAdapter2(getContext(), produkty);
                    lista.setAdapter(productAdapter);
                }*/
            /*}

            @Override
            public void onFailure(Call<GsonListDecorator<Product>> call, Throwable t) {
                a.setText("nie dziala");
            }
        });*/



        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new SupplierProductPredictActivity());
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        return v;
    }
}
