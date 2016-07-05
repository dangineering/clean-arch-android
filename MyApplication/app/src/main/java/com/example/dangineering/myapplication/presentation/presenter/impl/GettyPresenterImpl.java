package com.example.dangineering.myapplication.presentation.presenter.impl;

import android.widget.ImageView;

import com.example.dangineering.myapplication.data.model.ImageModel;
import com.example.dangineering.myapplication.data.repository.ImageRepository;
import com.example.dangineering.myapplication.domain.interactor.GetGettyImages;
import com.example.dangineering.myapplication.domain.interactor.impl.GetGettyImagesImpl;
import com.example.dangineering.myapplication.executors.InteractorExecutor;
import com.example.dangineering.myapplication.executors.MainThreadExecutor;
import com.example.dangineering.myapplication.executors.impl.InteractorExecutorImpl;
import com.example.dangineering.myapplication.executors.impl.MainThreadExecutorImpl;
import com.example.dangineering.myapplication.network.retrofit.GettyApiRepository;
import com.example.dangineering.myapplication.presentation.presenter.GettyPresenter;
import com.example.dangineering.myapplication.presentation.viewmodel.ImageViewModel;
import com.example.dangineering.myapplication.presentation.viewmodel.SampleViewModel;
import com.example.dangineering.myapplication.presentation.views.ModelListView;
import com.example.dangineering.myapplication.presentation.views.View;

import java.util.ArrayList;
import java.util.List;

public class GettyPresenterImpl implements GettyPresenter {

    GetGettyImages getGettyImages;
    ModelListView modelListView;

    @Override
    public void onImageSelected() {

    }

    @Override
    public void onSearch(String query) {

        getGettyImages.execute(query, new GetGettyImages.Callback() {
            @Override
            public void onResult(List<ImageModel> modelList) {
                getView().add(convertToViewModel(modelList));
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void initialize() {

        MainThreadExecutor mainThreadExecutorImpl = new MainThreadExecutorImpl();

        InteractorExecutor interactorExecutor = new InteractorExecutorImpl();

        ImageRepository imageRepository = new GettyApiRepository();

        getGettyImages = new GetGettyImagesImpl(interactorExecutor, mainThreadExecutorImpl, imageRepository);

    }



    @Override
    public void onViewCreate() {

    }

    @Override
    public void onViewResume() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void setView(ModelListView view) {
        this.modelListView = view;
    }

    @Override
    public ModelListView getView() {
        return modelListView;
    }

    private List<ImageViewModel> convertToViewModel(List<ImageModel> imageModels) {

        List<ImageViewModel> res = new ArrayList<>();

        for (ImageModel imageModel : imageModels) {

            res.add(new ImageViewModel(imageModel.getImageUrl(), imageModel.getDescription()));
        }

        return res;

    }
}
