package com.example.kooperatywalubelska.di;

import com.example.kooperatywalubelska.User.UserProductFragmentsListActivity;
import com.example.kooperatywalubelska.User.UserProductListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentContributorModule {

    @ContributesAndroidInjector
    abstract UserProductFragmentsListActivity contributeUserProductFragmentsListActivity();

    @ContributesAndroidInjector
    abstract UserProductListFragment contributeUserProductListActivity ();

}
