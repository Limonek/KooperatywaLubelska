package com.example.kooperatywalubelska.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kooperatywalubelska.R;

public class EventAdapter extends BaseAdapter {
    Context context;
    String[] nameEvent,dateEvent,discriptionEvent;
    LayoutInflater inflater;
    public EventAdapter(Context applicationContext, String[] nameEvent,String[] dateEvent,String[] discriptionEvent) {
        this.context=applicationContext;
        this.nameEvent=nameEvent;
        this.dateEvent=dateEvent;
        this.discriptionEvent=discriptionEvent;
        inflater=(LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return nameEvent.length;
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
        view  = inflater.inflate(R.layout.element_list_event_activity, null);
        TextView nameEventText = view.findViewById(R.id.nameEventText);
        TextView dateEventText = view.findViewById(R.id.dateEventText);
        TextView discriptionEventText = view.findViewById(R.id.discriptionEventText);
        nameEventText.setText(nameEvent[i]);
        dateEventText.setText(dateEvent[i]);
        discriptionEventText.setText(discriptionEvent[i]);
        return view;
    }
}
