package com.example.dangineering.myapplication.domain;

public interface GetSampleData {

    void execute(final Callback callback);

    interface Callback {

        void onResult();
    }

}
