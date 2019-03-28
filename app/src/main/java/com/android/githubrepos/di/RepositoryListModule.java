package com.android.githubrepos.di;

import com.android.githubrepos.repolist.ListActivity;
import com.android.githubrepos.repolist.ViewInterface;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RepositoryListModule {
    @Binds
    abstract ViewInterface provideFeatureView(ListActivity listActivity);
}
