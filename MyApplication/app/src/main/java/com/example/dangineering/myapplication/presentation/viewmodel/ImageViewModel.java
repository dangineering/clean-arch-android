package com.example.dangineering.myapplication.presentation.viewmodel;

public class ImageViewModel {

    private String imageUrl;

    private String description;

    public ImageViewModel(String imageUrl, String description) {
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
