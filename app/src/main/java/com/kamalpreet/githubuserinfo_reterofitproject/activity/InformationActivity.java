package com.kamalpreet.githubuserinfo_reterofitproject.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kamalpreet.githubuserinfo_reterofitproject.R;
import com.kamalpreet.githubuserinfo_reterofitproject.model.GitHubUser;
import com.kamalpreet.githubuserinfo_reterofitproject.rest.APIClient;
import com.kamalpreet.githubuserinfo_reterofitproject.rest.GitHubUserEndPoint;
import com.kamalpreet.githubuserinfo_reterofitproject.rest.ImageDownloader;


import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InformationActivity extends AppCompatActivity {

    TextView tv_login, tv_name, tv_followers, tv_following, tv_repo;
    Bitmap myImage;
    ImageView avatar;
    Button repo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        tv_login = findViewById(R.id.textView);
        tv_name = findViewById(R.id.tv_name);
        tv_followers = findViewById(R.id.tv_followers);
        tv_following = findViewById(R.id.tv_following);
        tv_repo = findViewById(R.id.tv_repo);
        avatar = findViewById(R.id.imageView);
        repo = findViewById(R.id.button2);

        Intent intent = getIntent();
        final String userName = intent.getStringExtra("userName");

        Toast.makeText(this,userName , Toast.LENGTH_LONG).show();

        final GitHubUserEndPoint apiService = APIClient.getClient().create(GitHubUserEndPoint.class);
        Call<GitHubUser> call = apiService.getUser(userName);
        call.enqueue(new Callback<GitHubUser>() {
            @Override
            public void onResponse(Call<GitHubUser> call, Response<GitHubUser> response)
            {
                ImageDownloader downloader = new ImageDownloader();
                try{
                    myImage = downloader.execute(response.body().getAvatar()).get();
                }catch (Exception e)
                {

                }


                Log.d("Name" , response.body().getName());
                tv_login.setText("Login : "+response.body().getLogin());
                tv_name.setText("Name : "+response.body().getName());
                tv_followers.setText("Followers : "+response.body().getFollowers());
                tv_following.setText("Following : "+response.body().getFollowing());
                tv_repo.setText("Repositories : "+response.body().getRepoCount());
                avatar.setImageBitmap(myImage);
            }

            @Override
            public void onFailure(Call<GitHubUser> call, Throwable t)
            {

            }
        });

        repo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(InformationActivity.this, RepositoryActivity.class);
                intent.putExtra("userName" , userName);
                startActivity(intent);
            }
        });
    }
}
