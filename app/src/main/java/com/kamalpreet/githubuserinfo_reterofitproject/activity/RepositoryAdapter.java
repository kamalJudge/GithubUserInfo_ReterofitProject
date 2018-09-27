package com.kamalpreet.githubuserinfo_reterofitproject.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kamalpreet.githubuserinfo_reterofitproject.model.GitHubRepo;
import com.kamalpreet.githubuserinfo_reterofitproject.model.GitHubUser;
import com.kamalpreet.githubuserinfo_reterofitproject.R;

import java.util.List;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepoViewHolder>
{
    private List<GitHubRepo> repos;
    private int rowLayout;
    private Context context;

    public RepositoryAdapter(List<GitHubRepo> repos, int rowLayout, Context context) {
        this.repos = repos;
        this.rowLayout = rowLayout;
        this.context = context;
        Log.d("Repos sixe" , repos.toString());
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position)
    {
        holder.repoName.setText("Name : "+repos.get(position).getName());
        holder.repoDescription.setText("Description : "+repos.get(position).getDescription());
        holder.repoLanguage.setText("Language : "+repos.get(position).getLanguage());

    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent , false);
        return new RepoViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return repos.size();

    }

    public List<GitHubRepo> getRepos() {
        return repos;
    }

    public void setRepos(List<GitHubRepo> repos) {
        this.repos = repos;
    }

    public int getRowLayout() {
        return rowLayout;
    }

    public void setRowLayout(int rowLayout) {
        this.rowLayout = rowLayout;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public static class RepoViewHolder extends RecyclerView.ViewHolder
    {
        ConstraintLayout reposLayout;
        TextView repoName, repoDescription, repoLanguage;
        public RepoViewHolder(View v)
        {
            super(v);
            reposLayout = (ConstraintLayout) v.findViewById(R.id.repoItem);
            repoName = (TextView) v.findViewById(R.id.tv_repoName);
            repoDescription = (TextView) v.findViewById(R.id.tv_repoDesc);
            repoLanguage = (TextView) v.findViewById(R.id.tv_repolanguage);


        }
    }
}
