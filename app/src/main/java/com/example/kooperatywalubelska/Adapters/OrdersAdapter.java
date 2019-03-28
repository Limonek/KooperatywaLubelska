package com.example.kooperatywalubelska.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kooperatywalubelska.R;

public class OrdersAdapter extends BaseAdapter {
    Context context;
    String[] listaDat;
    LayoutInflater inflater;

    public OrdersAdapter(Context applicationContext, String[] listaDat) {
        this.context=applicationContext;
        this.listaDat=listaDat;
        inflater=(LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return listaDat.length;
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
        TextView dataText = view.findViewById(R.id.NazwaProduktuText);
        TextView nazwa = view.findViewById(R.id.nazwaLabel);
        nazwa.setText("Data zamówienia:");
        dataText.setText(listaDat[i]);
        return view;
    }
}
