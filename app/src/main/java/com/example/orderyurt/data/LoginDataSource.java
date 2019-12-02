package com.example.orderyurt.data;

import android.util.Log;
import com.example.orderyurt.data.model.LoggedInUser;
import java.io.IOException;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(final String username, String password) {
        DataAPI loginAPI;
        loginAPI = ServiceGenerator.createService(DataAPI.class);

        Call<Map<String,String>> call = loginAPI.authenticateLogin(username,password);

        try {
            // TODO: handle loggedInUser authentication
            Log.i("test","test2");
            call.enqueue(new Callback<Map<String,String>>() {
            @Override
            public void onResponse(Call<Map<String,String>>  call, Response<Map<String,String>>  response) {
                if (!response.isSuccessful()){
                    new Result.Error(new IOException("Error logging in. Code: " + response.code()));
                }
                if (response.body() != null) {
                    Log.i("onSuccess", response.body().toString());

                    if(response.body().containsKey("success")) {
                        Log.i("onResponse", "success: " +response.body().toString());
                    }
                    else {
                        Log.i("onResponse","fail: "+response.code() + response.body().toString());
                    }
                }
            }
            @Override
            public void onFailure(Call<Map<String,String>>  call, Throwable t) {
                System.out.println("error in call");
            }
        });

        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
        LoggedInUser testUser =
                new LoggedInUser(
                        java.util.UUID.randomUUID().toString(),
                        username);
        return new Result.Success<>(testUser);
    }

    public void logout() {
        // TODO: revoke authentication
    }
}