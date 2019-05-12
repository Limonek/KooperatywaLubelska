package com.example.kooperatywalubelska.User;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTabHost;

import com.example.kooperatywalubelska.R;

public class UserProductFragmentsListActivity extends Fragment {

    private static final String TAG = UserProductFragmentsListActivity.class.getSimpleName();

    public UserProductFragmentsListActivity() {
    }

    private FragmentTabHost fragmentTabHost;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
        Log.i(TAG,"onCreateView: ");
        return inflater.inflate(R.layout.fragment_activity,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "onViewCreated: ");
        fragmentTabHost = view.findViewById(R.id.tabHost);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated: ");
        fragmentTabHost.setup(getActivity(), getChildFragmentManager(), android.R.id.tabcontent);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("zamowione").setIndicator("Zamówione"), UserProductOrderedFragment.class, null);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("wszystkie").setIndicator("Wszystkie"), UserProductListFragment.class, null);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("niezamowione").setIndicator("Nie zamówione"), UserProductNotOrderedFragment.class, null);

    }
}
