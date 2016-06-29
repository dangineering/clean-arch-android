package com.example.dangineering.myapplication.app;

import android.app.Application;
import android.content.res.Configuration;


public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
