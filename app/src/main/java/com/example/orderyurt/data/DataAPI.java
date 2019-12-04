package com.example.orderyurt.data;

import com.example.orderyurt.Accounts.RestaurantUser;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DataAPI {

    @POST("user/login")
    Call<Map<String,String>> authenticateLogin(@Query("username") String username, @Query("password") String password);
    @POST("user/add")
    Call<String> registerUserAccount(@Query("username") String username, @Query("email") String email, @Query("password") String password);

    @GET("restaurant/")
    Call<List<RestaurantUser>> getRestaurants();
    @POST("restaurant/add")
    Call<String> registerAccount(@Query("username") String username, @Query("name") String name, @Query("email") String email, @Query("password") String password);
}