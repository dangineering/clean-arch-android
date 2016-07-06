package com.example.dangineering.myapplication.app.di.module;


import android.content.Context;

import dagger.Module;

@Module
public class SampleModule {

    Context context;

    public SampleModule(Context context) {
        this.context = context;
    }

}
