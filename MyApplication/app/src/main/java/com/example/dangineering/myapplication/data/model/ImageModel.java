package com.example.dangineering.myapplication.data.model;

public class ImageModel {



    private String imageUrl;

    private String description;

    public ImageModel(String imageUrl, String description) {
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
