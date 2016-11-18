package com.example.boss.rx.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.boss.rx.R;
import com.example.boss.rx.model.GitHubRepo;

import java.util.ArrayList;
import java.util.List;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.RepoHolder>{

    List<GitHubRepo> repos = new ArrayList<>();

    public void addRepo(GitHubRepo repo) {
        repos.add(repo);
        notifyItemInserted(repos.size() - 1);
    }

    @Override
    public RepoHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.detail_element, viewGroup, false);

        return new RepoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RepoHolder repoHolder, int i) {
        repoHolder.bindTo(repos.get(i));
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public static class RepoHolder extends RecyclerView.ViewHolder {
        private final TextView firstLine;
        private final TextView secondLine;

        public RepoHolder(View itemView) {
            super(itemView);
            firstLine = (TextView) itemView.findViewById(R.id.firstLine);
            secondLine = (TextView) itemView.findViewById(R.id.secondLine);
        }

        public void bindTo(GitHubRepo repo) {
            firstLine.setText(String.format("%s (%s)", repo.getFull_name(), repo.getLanguage()));
            secondLine.setText(repo.getDescription());
        }
    }
}
