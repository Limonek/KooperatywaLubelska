package com.example.kooperatywalubelska.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kooperatywalubelska.R;

public class ProductAdapter extends BaseAdapter {
Context context;
String[] listaProduktów;
LayoutInflater inflater;

public ProductAdapter(Context applicationContext, String[] listaProduktów) {
    this.context=applicationContext;
    this.listaProduktów=listaProduktów;
    inflater=(LayoutInflater.from(applicationContext));
}
    @Override
    public int getCount() {
        return listaProduktów.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
    view  = inflater.inflate(R.layout.element_list_product_activity, null);
        TextView produkt = view.findViewById(R.id.NazwaProduktuText);
        produkt.setText(listaProduktów[i]);
    return view;
    }
}
