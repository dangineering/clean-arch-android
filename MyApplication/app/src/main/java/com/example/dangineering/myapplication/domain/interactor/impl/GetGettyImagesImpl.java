package com.example.dangineering.myapplication.domain.interactor.impl;

import com.example.dangineering.myapplication.data.model.ImageModel;
import com.example.dangineering.myapplication.data.repository.ImageRepository;
import com.example.dangineering.myapplication.domain.interactor.GetGettyImages;
import com.example.dangineering.myapplication.executors.InteractorExecutor;
import com.example.dangineering.myapplication.executors.MainThreadExecutor;

import java.util.List;

public class GetGettyImagesImpl extends com.example.dangineering.myapplication.domain.interactor.impl.AbstractInteractor implements GetGettyImages {

    // interactor impl depends on repository and callback

    ImageRepository imageRepository;
    Callback callback;
    String query;


    // Constructor takes in repository
    public GetGettyImagesImpl(InteractorExecutor interactorExecutor, MainThreadExecutor mainThreadExecutor, ImageRepository imageRepository) {
        super(interactorExecutor, mainThreadExecutor);
        this.imageRepository = imageRepository;
    }

    @Override
    public void execute(String query, Callback callback) {
        this.callback = callback;
        this.query = query;

        getInteractorExecutor().run(this);

    }

    @Override
    public void run() {

        final List<ImageModel> images = imageRepository.getImageModels(query);

        getMainThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                callback.onResult(images);
            }
        });


    }
}
