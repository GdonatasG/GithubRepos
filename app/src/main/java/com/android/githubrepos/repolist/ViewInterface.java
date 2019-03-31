package com.android.githubrepos.repolist;

import com.android.githubrepos.viewmodel.RepositoryListItem;

import java.util.List;

public interface ViewInterface {
    void setUpAdapterAndView(List<RepositoryListItem> listOfData);

    void showErrorMessage(String error);

    void startMainActivity();

    void showLoadingIndicator();
}
