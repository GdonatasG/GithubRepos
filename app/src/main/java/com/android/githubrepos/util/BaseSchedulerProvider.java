package com.android.githubrepos.util;

import io.reactivex.Scheduler;

public interface BaseSchedulerProvider {
    Scheduler getIOScheduler();

    Scheduler getComputerScheduler();

    Scheduler getUiScheduler();
}
