package com.example.boss.rx.service;

import com.example.boss.rx.model.GitHubRepo;
import com.example.boss.rx.model.GitHubUser;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GitUserService {

    String ENDPOINT = "https://api.github.com";

    @GET("users/{user}")
    Observable<GitHubUser> getUserData(@Path("user") String user);

    @GET("/users/{user}/repos")
    Observable<GitHubRepo[]> getRepoData(@Path("user") String user);
}
