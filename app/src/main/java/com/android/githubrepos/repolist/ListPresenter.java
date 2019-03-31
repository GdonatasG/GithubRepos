package com.android.githubrepos.repolist;

import android.arch.lifecycle.LifecycleObserver;
import android.widget.ListView;

import com.android.githubrepos.data.RepositoryDataSourceInterface;
import com.android.githubrepos.datamodel.RepositoryDataModel;
import com.android.githubrepos.util.BaseSchedulerProvider;
import com.android.githubrepos.viewmodel.ListViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.subscribers.DisposableSubscriber;

public class ListPresenter implements LifecycleObserver {

    // An activity or fragment
    private ViewInterface view;

    // Abstraction of dataSource
    private RepositoryDataSourceInterface dataSource;

    // Helps to manage reactive streams
    private CompositeDisposable disposable;

    // Helps to provide rx implementation with scheduler
    private BaseSchedulerProvider scheduler;

    @Inject
    public ListPresenter(ViewInterface view,
                         RepositoryDataSourceInterface dataSource,
                         BaseSchedulerProvider scheduler) {
        this.view = view;
        this.dataSource = dataSource;
        this.disposable = new CompositeDisposable();
        this.scheduler = scheduler;
    }

    public void start(String user) {
        getListFromDataSource(user);
    }

    public void stop() {
        // Helps us stop our background operations when they should be stopped.
        disposable.clear();
    }

    private void getListFromDataSource(String user) {
        disposable.add(
                // Return data from the dataSource wrapped in a Flowable
                dataSource.getUserRepositories(user)
                        // Return this data on the UI thread
                        .observeOn(scheduler.getUiScheduler())
                        // Start stream with a loading screen
                        .startWith(
                                ListViewModel.loading()
                        )
                        // If error, return ListViewModel.error instance
                        .onErrorReturn(new Function<Throwable, ListViewModel>() {
                            @Override
                            public ListViewModel apply(Throwable throwable) throws Exception {
                                return ListViewModel.error(throwable.getMessage());
                            }
                        })
                        // The resulting Flowable should be subscribed with this new subscriber
                        .subscribeWith(new DisposableSubscriber<ListViewModel>() {
                            @Override
                            public void onNext(ListViewModel uiModel) {
                                // When we get ui model, handle it here
                                if (uiModel.hasError()) {
                                    view.showErrorMessage(uiModel.getErrorMessage());
                                    view.startMainActivity();
                                } else if (uiModel.isLoading()) {
                                    view.showLoadingIndicator();
                                } else {
                                    view.setUpAdapterAndView(uiModel.getRepoList());
                                }

                            }

                            @Override
                            public void onError(Throwable t) {
                                // Application errors handler

                            }

                            @Override
                            public void onComplete() {

                            }
                        })

        );
    }


}
