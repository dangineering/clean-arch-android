package com.example.dangineering.myapplication.domain.interactor.impl;

import com.example.dangineering.myapplication.domain.interactor.Interactor;
import com.example.dangineering.myapplication.executors.InteractorExecutor;
import com.example.dangineering.myapplication.executors.MainThreadExecutor;

public abstract class AbstractInteractor implements Interactor {

    private InteractorExecutor interactorExecutor;
    private MainThreadExecutor mainThreadExecutor;

    public AbstractInteractor(InteractorExecutor interactorExecutor, MainThreadExecutor mainThreadExecutor) {
        this.interactorExecutor = interactorExecutor;
        this.mainThreadExecutor = mainThreadExecutor;
    }

    public InteractorExecutor getInteractorExecutor() {
        return interactorExecutor;
    }

    public void setInteractorExecutor(InteractorExecutor interactorExecutor) {
        this.interactorExecutor = interactorExecutor;
    }

    public MainThreadExecutor getMainThreadExecutor() {
        return mainThreadExecutor;
    }

    public void setMainThreadExecutor(MainThreadExecutor mainThreadExecutor) {
        this.mainThreadExecutor = mainThreadExecutor;
    }

}
