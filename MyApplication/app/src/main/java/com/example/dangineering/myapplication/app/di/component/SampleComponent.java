package com.example.dangineering.myapplication.app.di.component;


import android.app.Activity;

import com.example.dangineering.myapplication.app.di.module.SampleModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={SampleModule.class})
public interface SampleComponent {
    // to inject into views
    void inject(Activity activity);
}
