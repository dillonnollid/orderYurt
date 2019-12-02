package com.example.orderyurt.data;

import com.example.orderyurt.Accounts.RestaurantUser;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface DataAPI {

//    @POST("login")
//    Call<Map<String,String>> authenticateLogin(@QueryMap Map<String,String> loginCredentialsMap);

    @POST("user/login")
    Call<Map<String,String>> authenticateLogin(@Query("username") String username, @Query("password") String password);

    @GET("restaurant/")
    Call<List<RestaurantUser>> getRestaurants();

//    @POST("login ")
//    Call<Map<String,String>> authenticateLogin(@Body Map<String,String> loginCredentialsMap);

}
