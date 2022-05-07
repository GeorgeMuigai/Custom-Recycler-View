package com.gdev.ig;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface PostApi {

    @GET("?key=27212857-11addb82f02d6bb8ba624eb3f&q=nature&image_type=photo&pretty=true")
    Call<PostModal> getAllPosts();

    @GET()
    Call<PostModal> getPostsByPage(Url url);
}
