package com.example.kooperatywalubelska.User;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.kooperatywalubelska.Adapters.EventAdapter;
import com.example.kooperatywalubelska.R;

public class UserEventDeclaredFragment extends Fragment {
    private ListView lista ;
    String[] nameEvent = {"Podział produktów styczeń",  "Nowi dostawcy"};
    String[] dateEvent = {"20-01-2019", "3.02.2019"};
    String[] discriptionEvent = {"Podział produktów między członkami społeczności kooperatywy", "Wybór nowych dostawców do kooperatywy"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_clear_activity,container, false);

        lista = v.findViewById(R.id.lista);
        EventAdapter eventAdapter = new EventAdapter(v.getContext(),nameEvent,dateEvent,discriptionEvent);
        lista.setAdapter(eventAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentTransaction transaction = getParentFragment().getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new UserEventInformationFragment());
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        return v;
    }
}