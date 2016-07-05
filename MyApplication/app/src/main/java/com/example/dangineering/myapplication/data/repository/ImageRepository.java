package com.example.dangineering.myapplication.data.repository;

import com.example.dangineering.myapplication.data.model.ImageModel;
import com.example.dangineering.myapplication.network.responsemodel.Image;

import java.util.List;

public interface ImageRepository {

    List<ImageModel> getImageModels(String query);
}
