package com.example.dangineering.myapplication.data.model;

public class SampleImageModel {

    private String imageUrl;

    private String description;

    public SampleImageModel(String imageUrl, String description) {
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }


}
