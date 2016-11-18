package com.example.boss.rx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.boss.rx.util.GitHubWrapper;
import com.example.boss.rx.util.OnRVItemClickListener;
import com.example.boss.rx.util.UsersAdapter;

public class MainActivity extends AppCompatActivity implements OnRVItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsersAdapter adapter = new UsersAdapter(this);
        GitHubWrapper.getUserInfo(adapter);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.usersList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(String username) {
        startActivity(DetailActivity.from(this, username));
    }
}
