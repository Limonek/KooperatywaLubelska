package com.example.kooperatywalubelska.di;

import com.example.kooperatywalubelska.User.UserProductFragmentsListActivity;
import com.example.kooperatywalubelska.User.UserProductListFragment;
import com.example.kooperatywalubelska.User.UserProductNotOrderedFragment;
import com.example.kooperatywalubelska.User.UserProductOrderedFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentContributorModule {

    @ContributesAndroidInjector
    abstract UserProductFragmentsListActivity contributeUserProductFragmentsListActivity();

    @ContributesAndroidInjector
    abstract UserProductListFragment contributeUserProductListActivity ();

    @ContributesAndroidInjector
    abstract UserProductNotOrderedFragment contributeUserProductNotOrderedFragment();

    @ContributesAndroidInjector
    abstract UserProductOrderedFragment contributeUserProductOrderedFragment();

}
