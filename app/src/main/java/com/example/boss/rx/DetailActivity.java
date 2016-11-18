package com.example.boss.rx;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.boss.rx.util.GitHubWrapper;
import com.example.boss.rx.util.ReposAdapter;

public class DetailActivity extends AppCompatActivity {

    private static final String USER_KEY = "user";
    private RecyclerView reposList;
    private String requestedUser;

    public static Intent from(Context context, String username) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(USER_KEY, username);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        requestedUser = getIntent().getStringExtra(USER_KEY);
        setTitle(requestedUser);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        ReposAdapter adapter = new ReposAdapter();
        GitHubWrapper.getRepoInfo(requestedUser, adapter);

        reposList = (RecyclerView) findViewById(R.id.reposList);
        reposList.setLayoutManager(layoutManager);
        reposList.setAdapter(adapter);
    }
}