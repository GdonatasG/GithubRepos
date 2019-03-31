package com.android.githubrepos.data;

import com.android.githubrepos.datamodel.RepositoryDataModel;
import com.android.githubrepos.error.EmptyDatasetException;
import com.android.githubrepos.viewmodel.ListViewModel;
import com.android.githubrepos.viewmodel.RepositoryListItem;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class RepositoryDataSourceImpl implements RepositoryDataSourceInterface {
    private GitHubRestAdapter restAdapter;

    @Inject
    public RepositoryDataSourceImpl(GitHubRestAdapter restAdapter) {
        this.restAdapter = restAdapter;
    }

    @Override
    public Flowable<ListViewModel> getUserRepositories(String user) {
        return
                // Return a Flowable of type List<RepositoryDataModel>
                restAdapter.getUserRepositories(user)
                        // Transform the data from RepositoryDataModels to ListViewModels
                        .flatMap(
                                new Function<//Input:
                                        List<RepositoryDataModel>,
                                        // Output
                                        Publisher<ListViewModel>>() {
                                    @Override
                                    public Publisher<ListViewModel>
                                    apply(List<RepositoryDataModel> repositoryDataModels) throws Exception {
                                        List<RepositoryListItem> listItems = new ArrayList<>();
                                        if (repositoryDataModels.size() == 0) {
                                            throw new EmptyDatasetException();
                                        }

                                        for (RepositoryDataModel repo : repositoryDataModels) {
                                            listItems.add(
                                                    new RepositoryListItem(repo.getDescription(), repo.getCreated_at(), repo.getAvatarURL())
                                            );
                                        }

                                        // Emit what`s in the brackets
                                        return Flowable.just(ListViewModel.success(listItems));
                                    }
                                }
                        )
                        // Do this work fetching the data and transforming it on a background thread
                        .subscribeOn(Schedulers.io());
    }
}
