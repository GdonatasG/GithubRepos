package com.android.githubrepos.repolist;

public interface ViewInterface {
    void setUpAdapterAndView(List<RepositoryListItem> listOfData);

    void showErrorMessage(String error);

    void startMainActivity();

    void showLoadingIndicator();
}
