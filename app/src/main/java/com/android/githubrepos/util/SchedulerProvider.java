package com.android.githubrepos.util;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SchedulerProvider implements BaseSchedulerProvider {
    @Override
    public Scheduler getIOScheduler() {
        return Schedulers.io();
    }

    @Override
    public Scheduler getComputerScheduler() {
        return Schedulers.computation();
    }

    @Override
    public Scheduler getUiScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
