package com.example.dangineering.myapplication.app.di.module;


import android.content.Context;

import dagger.Module;

@Module
public class AuthModule {


    Context context;

    public AuthModule(Context context) {
        this.context = context;
    }


}
