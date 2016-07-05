package com.example.dangineering.myapplication.executors.impl;

import android.os.Handler;
import android.os.Looper;

import com.example.dangineering.myapplication.executors.MainThreadExecutor;


public class MainThreadExecutorImpl implements MainThreadExecutor {

    private Handler handler;

    public MainThreadExecutorImpl() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void execute(Runnable runnable) {
        handler.post(runnable);
    }
}
