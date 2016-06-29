package com.example.dangineering.myapplication.presentation.views;

import com.example.dangineering.myapplication.presentation.viewmodel.SampleViewModel;

import java.util.List;

public interface ModelListView extends View {

    void add(SampleViewModel sampleViewModel);

    void add(List<SampleViewModel> sampleViewModelList);

    void remove(SampleViewModel sampleViewModel);
}
