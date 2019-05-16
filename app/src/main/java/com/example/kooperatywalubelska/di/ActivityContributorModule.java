package com.example.kooperatywalubelska.di;

import com.example.kooperatywalubelska.Supplier.SupplierMain;
import com.example.kooperatywalubelska.User.LoginActivity;
import com.example.kooperatywalubelska.User.UserMain;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityContributorModule {

    @ContributesAndroidInjector()
    abstract UserMain contributeMainActivity();

    @ContributesAndroidInjector()
    abstract SupplierMain contributeSupplieMainActivity();

    @ContributesAndroidInjector()
    abstract LoginActivity contributeLoginActivity();

}
