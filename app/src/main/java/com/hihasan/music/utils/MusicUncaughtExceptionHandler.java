package com.hihasan.music.utils;

import androidx.annotation.NonNull;

public class MusicUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler systemExceptionHandler;
    private Thread thread;
    private Throwable exception;

    public MusicUncaughtExceptionHandler(Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler) {
        systemExceptionHandler = defaultUncaughtExceptionHandler;
    }

    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
        this.thread = t;
        exception = e;
        e.printStackTrace();
        System.exit(2);
        systemExceptionHandler.uncaughtException(thread, exception);
    }
}
