package com.kamalpreet.githubuserinfo_reterofitproject.model;

import com.google.gson.annotations.SerializedName;

public class GitHubUser
{
    @SerializedName("login")
    private String login;

    @SerializedName("name")
    private String name;

    @SerializedName("followers")
    private String followers;

    @SerializedName("following")
    private String following;

    @SerializedName("public_repos")
    private String publicRepoCount;

    @SerializedName("avatar_url")
    private String avatar;


    public GitHubUser(String login, String name, String followers, String following, String repoCount, String avatar) {
        this.login = login;
        this.name = name;
        this.followers = followers;
        this.following = following;
        this.publicRepoCount = repoCount;
        this.avatar = avatar;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getRepoCount() {
        return publicRepoCount;
    }

    public void setRepoCount(String repoCount) {
        this.publicRepoCount = repoCount;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
