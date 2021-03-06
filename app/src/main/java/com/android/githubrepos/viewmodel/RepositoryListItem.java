package com.android.githubrepos.viewmodel;

public class RepositoryListItem {
    private final String repoDescription;
    private final String repoCreationDate;
    private final String repoAvatarUrl;

    public RepositoryListItem(String repoDescription,
                              String repoCreationDate,
                              String repoAvatarUrl) {
        this.repoDescription = repoDescription;
        this.repoCreationDate = repoCreationDate;
        this.repoAvatarUrl = repoAvatarUrl;
    }

    public String getRepoDescription() {
        return repoDescription;
    }

    public String getRepoCreationDate() {
        return repoCreationDate;
    }

    public String getRepoAvatarUrl() {
        return repoAvatarUrl;
    }
}
