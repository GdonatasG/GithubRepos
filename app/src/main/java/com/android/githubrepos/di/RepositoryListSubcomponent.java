package com.android.githubrepos.di;

import com.android.githubrepos.repolist.ListActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = RepositoryListModule.class)
public interface RepositoryListSubcomponent extends AndroidInjector<ListActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ListActivity> {
    }
}
