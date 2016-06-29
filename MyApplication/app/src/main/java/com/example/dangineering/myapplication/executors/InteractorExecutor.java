package com.example.dangineering.myapplication.executors;

import com.example.dangineering.myapplication.domain.Interactor;

/**
 * Interface for an executor that will run one or more interactors, which implement Runnable
 */
public interface InteractorExecutor {

    void run(Interactor interactor);
}
