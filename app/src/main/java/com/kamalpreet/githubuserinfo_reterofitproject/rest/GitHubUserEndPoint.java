package com.kamalpreet.githubuserinfo_reterofitproject.rest;

import com.kamalpreet.githubuserinfo_reterofitproject.model.GitHubRepo;
import com.kamalpreet.githubuserinfo_reterofitproject.model.GitHubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubUserEndPoint
{
    @GET("/users/{user}")
    Call<GitHubUser> getUser(@Path("user") String user);

    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> getRepo(@Path("user") String user);
}
