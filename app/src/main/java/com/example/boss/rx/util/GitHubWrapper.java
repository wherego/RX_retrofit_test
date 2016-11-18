package com.example.boss.rx.util;

import com.example.boss.rx.service.GitUserService;
import com.example.boss.rx.service.ServiceFactory;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GitHubWrapper {

    private static final String[] interestingUsers = {"JakeWharton", "yaroslav-rybiak", "nickbutcher", "dmayboroda", "leshkou"};

    public static void getUserInfo(final UsersAdapter adapter) {

        GitUserService gitUserService =
                ServiceFactory.createServiceFrom(GitUserService.class, GitUserService.ENDPOINT);

        Observable.from(interestingUsers)
                .flatMap(gitUserService::getUserData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(adapter::addUser);
    }

    public static void getRepoInfo(final String user, final ReposAdapter adapter){

        GitUserService gitUserService =
                ServiceFactory.createServiceFrom(GitUserService.class, GitUserService.ENDPOINT);

        gitUserService.getRepoData(user)
                .flatMap(Observable::from)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(adapter::addRepo);
    }
}
