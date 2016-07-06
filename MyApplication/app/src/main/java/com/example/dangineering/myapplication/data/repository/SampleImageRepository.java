package com.example.dangineering.myapplication.data.repository;

import com.example.dangineering.myapplication.data.model.SampleImageModel;

import java.util.List;

public interface SampleImageRepository {

    List<SampleImageModel> getImageModels(String query);
}
