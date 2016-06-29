package com.example.dangineering.myapplication.executors;

/**
 * Executor for handling runnables on main thread for UI callbacks.
 */
public interface MainThreadExecutor {

    void execute(Runnable runnable);

}
