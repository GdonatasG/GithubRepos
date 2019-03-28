package com.android.githubrepos.di;

import android.app.Activity;

import com.android.githubrepos.repolist.ListActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module
public abstract class BuildersModule {

    //Add Bindings to Sub-Components here
    @Binds
    @IntoMap
    @ActivityKey(ListActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindListActivityInjectorFactory(RepositoryListSubcomponent.Builder builder);
}
