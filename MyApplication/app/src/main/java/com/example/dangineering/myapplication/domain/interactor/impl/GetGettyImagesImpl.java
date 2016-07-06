package com.example.dangineering.myapplication.domain.interactor.impl;

import com.example.dangineering.myapplication.data.model.SampleImageModel;
import com.example.dangineering.myapplication.data.repository.SampleImageRepository;
import com.example.dangineering.myapplication.domain.interactor.GetGettyImages;
import com.example.dangineering.myapplication.executors.InteractorExecutor;
import com.example.dangineering.myapplication.executors.MainThreadExecutor;

import java.util.List;

public class GetGettyImagesImpl extends com.example.dangineering.myapplication.domain.interactor.impl.AbstractInteractor implements GetGettyImages {

    // interactor impl depends on repository and callback and arguments

    SampleImageRepository sampleImageRepository;
    Callback callback;
    String query;


    // Constructor takes in repository
    public GetGettyImagesImpl(InteractorExecutor interactorExecutor, MainThreadExecutor mainThreadExecutor, SampleImageRepository sampleImageRepository) {
        super(interactorExecutor, mainThreadExecutor);
        this.sampleImageRepository = sampleImageRepository;
    }

    @Override
    public void execute(String query, Callback callback) {
        this.callback = callback;
        this.query = query;

        getInteractorExecutor().run(this);

    }

    @Override
    public void run() {

        final List<SampleImageModel> images = sampleImageRepository.getImageModels(query);

        getMainThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                callback.onResult(images);
            }
        });


    }
}
