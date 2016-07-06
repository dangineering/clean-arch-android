package com.example.dangineering.myapplication.domain.interactor;

import com.example.dangineering.myapplication.data.model.SampleImageModel;

import java.util.List;

public interface GetGettyImages {

    void execute(String query, Callback callback);


    interface Callback {

        void onResult(List<SampleImageModel> modelList);

        void onError();
    }
}
