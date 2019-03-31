package com.android.githubrepos.datamodel;

import com.squareup.moshi.Json;

public class RepositoryDataModel {
    final String description;
    @Json(name = "created_at")
    final String created_at;
    final Owner owner;

    public RepositoryDataModel(String description, String created_at, Owner owner) {
        this.description = description;
        this.created_at = created_at;
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getAvatarURL(){
        return this.owner.getAvatar_url();
    }

    public Owner getOwner() {
        return owner;
    }

    static class Owner {
        final String avatar_url;

        public Owner(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public String getAvatar_url() {
            return avatar_url;
        }
    }

}
