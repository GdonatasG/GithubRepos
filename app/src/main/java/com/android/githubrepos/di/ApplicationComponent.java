package com.android.githubrepos.di;

import com.android.githubrepos.GitHubApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        BuildersModule.class
})
public interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(GitHubApplication application);

        ApplicationComponent build();
    }

    void inject(GitHubApplication application);
}
