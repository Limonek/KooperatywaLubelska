package com.example.kooperatywalubelska.di;

import com.example.kooperatywalubelska.User.UserMain;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityContributorModule {

    @ContributesAndroidInjector()
    abstract UserMain contributeMainActivity();

}
