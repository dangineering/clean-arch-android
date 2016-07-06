package com.example.dangineering.myapplication.presentation.views;

import com.example.dangineering.myapplication.presentation.viewmodel.ImageViewModel;

import java.util.List;

public interface ModelListView extends View {

    void add(ImageViewModel sampleViewModel);

    void add(List<ImageViewModel> sampleViewModelList);

    void remove(ImageViewModel sampleViewModel);

}
