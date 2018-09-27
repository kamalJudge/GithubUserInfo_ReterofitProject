package com.kamalpreet.githubuserinfo_reterofitproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.kamalpreet.githubuserinfo_reterofitproject.R;
import com.kamalpreet.githubuserinfo_reterofitproject.model.GitHubRepo;
import com.kamalpreet.githubuserinfo_reterofitproject.model.GitHubUser;
import com.kamalpreet.githubuserinfo_reterofitproject.rest.APIClient;
import com.kamalpreet.githubuserinfo_reterofitproject.rest.GitHubUserEndPoint;
import com.kamalpreet.githubuserinfo_reterofitproject.rest.ImageDownloader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryActivity extends AppCompatActivity {

    String userName;
    TextView user_Name;
    RecyclerView recyclerView;
    List<GitHubRepo> repoList = new ArrayList<>();
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo);

        Intent intent = getIntent();
        userName = intent.getStringExtra("userName");
        user_Name = (TextView) findViewById(R.id.tv_userName);
        user_Name.setText("USER : "+userName);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RepositoryAdapter(repoList , R.layout.repo_contents, getApplicationContext());
        recyclerView.setAdapter(adapter);

        final GitHubUserEndPoint apiService = APIClient.getClient().create(GitHubUserEndPoint.class);
        Call<List<GitHubRepo>> call = apiService.getRepo(userName);
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response)
            {
                repoList.clear();
                repoList.addAll(response.body());
                Log.d("Repo Avtivity", repoList.toString());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t)
            {

            }
        });

    }

}
