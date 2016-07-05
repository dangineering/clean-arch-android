package com.example.dangineering.myapplication.app.di.component;


import android.app.Activity;

import com.example.dangineering.myapplication.app.di.module.AuthModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={AuthModule.class})
public interface AuthComponent {


    // to inject into views
    void inject(Activity activity);

}
