package com.example.orderyurt.Login;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import com.example.orderyurt.Controllers.R;
import com.example.orderyurt.data.DataAPI;
import com.example.orderyurt.data.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_account);

        final ProgressBar loadingProgressBar = findViewById(R.id.loading);
        final EditText usernameEditText = findViewById(R.id.username);
        final EditText emailEditText = findViewById(R.id.email);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button registerButton = findViewById(R.id.registerBtn);
        final Button registerUserBtn = findViewById(R.id.registerUserBtn);
        registerUserBtn.setEnabled(true);
        registerButton.setEnabled(true);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                String username = usernameEditText.getText().toString();
                String password = emailEditText.getText().toString();
                String email = passwordEditText.getText().toString();
                registerAccount(username, password,email);
                Intent intent = new Intent(RegisterAccount.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        registerUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                String username = usernameEditText.getText().toString();
                String password = emailEditText.getText().toString();
                String email = passwordEditText.getText().toString();
                registerUserAccount(username, password,email);
                Intent intent = new Intent(RegisterAccount.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    //registers restaurant
    public static void registerAccount(String username, String email, String password){
        DataAPI orderUpAPI;
        orderUpAPI = ServiceGenerator.createService(DataAPI.class);

        Call<String> call = orderUpAPI.registerAccount(username, username, email, password);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (!response.isSuccessful()){
//                    new Result.Error(new IOException("Error logging in. Code: " + response.code()));
                }
                if (response.body() != null)
                    Log.i("RegisterAccount","non null response received");
            }
            @Override
            public void onFailure(Call<String>  call, Throwable t) {
                System.out.println("error in LoginDataSource:onFailure");
            }
        });
    }

    //Registers normal user (placing food orders)
    public static void registerUserAccount(String username, String email, String password){
        DataAPI orderUpAPI;
        orderUpAPI = ServiceGenerator.createService(DataAPI.class);

        Call<String> call = orderUpAPI.registerUserAccount(username, email, password);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (!response.isSuccessful()){
//                    new Result.Error(new IOException("Error logging in. Code: " + response.code()));
                }
                if (response.body() != null)
                    Log.i("RegisterAccount","non null response received");
            }
            @Override
            public void onFailure(Call<String>  call, Throwable t) {
                System.out.println("error in LoginDataSource:onFailure");
            }
        });
    }
}
