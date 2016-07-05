package com.example.dangineering.myapplication.domain.interactor;

import com.example.dangineering.myapplication.data.model.ImageModel;

import java.util.List;

public interface GetGettyImages {

    void execute(String query, Callback callback);


    interface Callback {

        void onResult(List<ImageModel> modelList);

        void onError();
    }
}
