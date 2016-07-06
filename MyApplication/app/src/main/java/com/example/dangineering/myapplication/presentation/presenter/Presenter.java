package com.example.dangineering.myapplication.presentation.presenter;

import com.example.dangineering.myapplication.presentation.views.View;

public interface Presenter<T extends View> {

    void initialize();

    void onViewCreate();

    void onViewResume();
    
    // Release resources
    void onViewDestroy();

    void setView(T view);

    View getView();
}
