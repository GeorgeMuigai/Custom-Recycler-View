package com.gdev.ig;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Hits> hitsList = new ArrayList<>();
    PostAdapter adapter;
    RecyclerView rv_posts;
    ProgressBar progressBar;
    TextView txt_getting_posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new PostAdapter(hitsList);
        rv_posts = findViewById(R.id.rv_posts);
        progressBar = findViewById(R.id.progress_circular);
        txt_getting_posts = findViewById(R.id.txt_getting_posts);

        rv_posts.setLayoutManager(new LinearLayoutManager(this));
        rv_posts.setAdapter(adapter);

        RetrofitClient();
    }

    private void RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pixabay.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostApi postApi = retrofit.create(PostApi.class);

        Call<PostModal> posts = postApi.getAllPosts();

        posts.enqueue(new Callback<PostModal>() {
            @Override
            public void onResponse(Call<PostModal> call, Response<PostModal> response) {
                progressBar.setVisibility(View.GONE);
                txt_getting_posts.setVisibility(View.GONE);
                if(!response.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "Error Code : " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                PostModal postModal = response.body();
                ArrayList<Hits> arrayList = postModal.getHits();

                for (int i = 0; i < arrayList.size(); i++)
                {
                    hitsList.add(new Hits(arrayList.get(i).getUserImageURL(), arrayList.get(i).getUser(), arrayList.get(i).getType(),
                            arrayList.get(i).getLargeImageURL(), arrayList.get(i).getLikes(), arrayList.get(i).getComments(), arrayList.get(i).getViews()));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PostModal> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
                txt_getting_posts.setVisibility(View.GONE);
            }
        });
    }
}