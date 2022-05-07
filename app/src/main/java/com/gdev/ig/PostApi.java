package com.gdev.ig;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi {

    @GET("?key=27212857-11addb82f02d6bb8ba624eb3f&q=sportscar&image_type=photo&pretty=true")
    Call<PostModal> getAllPosts();
}
