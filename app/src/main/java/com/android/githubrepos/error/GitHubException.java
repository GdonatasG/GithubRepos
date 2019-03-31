package com.android.githubrepos.error;

import java.io.IOException;

class GitHubException extends IOException {
    private int responseCode;
    private String message;

    public int getResponseCode() {
        return responseCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public GitHubException(int code, String message) {
        this.responseCode = code;
        this.message = message;
    }
}
