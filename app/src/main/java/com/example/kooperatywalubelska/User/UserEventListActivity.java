package com.example.kooperatywalubelska.User;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kooperatywalubelska.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTabHost;

public class UserEventListActivity extends Fragment {

    private static final String TAG = UserProductFragmentsListActivity.class.getSimpleName();

    public UserEventListActivity() {
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
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("wszystkie").setIndicator("Wszystkie"), UserEventsAllActivity.class,null);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("zadeklarowane").setIndicator("Zadeklarowane"), UserEventDeclaredActivity.class,null);

    }
}

