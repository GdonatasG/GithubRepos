package com.android.githubrepos.error;

import java.io.IOException;

public class EmptyDatasetException extends IOException {
    private final String message;

    public EmptyDatasetException() {
        this.message = "No Repos listed for given Username";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
