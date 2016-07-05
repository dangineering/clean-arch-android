package com.example.dangineering.myapplication.presentation.presenter;

import com.example.dangineering.myapplication.presentation.views.ModelListView;

public interface GettyPresenter extends Presenter<ModelListView> {

    void onImageSelected();

    void onSearch(String query);
}
