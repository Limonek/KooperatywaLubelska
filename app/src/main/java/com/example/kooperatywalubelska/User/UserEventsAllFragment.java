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

public class UserEventsAllFragment extends Fragment {
    private ListView lista ;

    String[] nameEvent = {"Podział produktów styczeń", "Zdrowe żywienie", "Nowi dostawcy", "Podział produktów Luty"};
    String[] dateEvent = {"20-01-2019", "27.01.2019", "3.02.2019", "10.02.2019"};
    String[] discriptionEvent = {"Podział produktów między członkami społeczności kooperatywy", "Rozmowa z dietetykiem o zdrowych produkach w diecie", "Wybór nowych dostawców do kooperatywy", "Podział produktów między członkami społeczności kooperatywy"};

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
