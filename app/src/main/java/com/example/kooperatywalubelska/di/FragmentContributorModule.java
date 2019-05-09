package com.example.kooperatywalubelska.di;

import com.example.kooperatywalubelska.User.UserProductFragmentsListActivity;
import com.example.kooperatywalubelska.User.UserProductListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentContributorModule {

    @ContributesAndroidInjector
    abstract UserProductFragmentsListActivity contributeUserProductFragmentsListActivity();

    @ContributesAndroidInjector
    abstract UserProductListActivity contributeUserProductListActivity ();

}
