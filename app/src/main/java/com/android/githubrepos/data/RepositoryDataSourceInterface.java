package com.android.githubrepos.data;


import com.android.githubrepos.viewmodel.ListViewModel;

import java.util.List;

import io.reactivex.Flowable;

public interface RepositoryDataSourceInterface {
    Flowable<ListViewModel> getUserRepositories(String user);
}
