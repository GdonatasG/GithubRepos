package com.android.githubrepos.data;

import com.android.githubrepos.datamodel.RepositoryDataModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class GitHubRestAdapter {

    private final GitHubService gitHubService;

    @Inject
    public GitHubRestAdapter(Retrofit retrofit) {
        this.gitHubService = retrofit.create(GitHubService.class);
    }

    public interface GitHubService {

        @GET(UrlManager.REPOS)
        Flowable<List<RepositoryDataModel>> getUserPublicRepositories(
                @Path("user") String user
        );
    }

    public Flowable<List<RepositoryDataModel>> getUserRepositories(final String user) {
        return gitHubService.getUserPublicRepositories(user);
    }
}
