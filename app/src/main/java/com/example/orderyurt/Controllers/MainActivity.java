package com.example.orderyurt.Controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.orderyurt.Accounts.RestaurantUser;
import com.example.orderyurt.data.DataAPI;
import com.example.orderyurt.data.Result;
import com.example.orderyurt.data.ServiceGenerator;
import com.example.orderyurt.data.model.LoggedInUser;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//TODO: ADD MVC!!
/**
 * The MainActivity method displays a list of restaurants to the User with a Spinner
 * The User can choose the participating restaurant where they wish to dine by clicking the view menu button.
 * @spinner object will hold our Restaurant names and the restaurant chosen
 * @restaurantArray contains participating restaurants
 * @spinnerArrayAdapter allows Spinner onClick actions
 * **/
public class MainActivity extends AppCompatActivity {
    //Show list of restaurants
    //Show list of tables for specified restaurant
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);

        DataAPI orderUpAPI;
        orderUpAPI = ServiceGenerator.createService(DataAPI.class);

        Call<List<RestaurantUser>> call = orderUpAPI.getRestaurants();

            call.enqueue(new Callback<List<RestaurantUser>>() {
                @Override
                public void onResponse(Call<List<RestaurantUser>> call, Response<List<RestaurantUser>> response) {
                    if (!response.isSuccessful()){
                        new Result.Error(new IOException("Error logging in. Code: " + response.code()));
                    }
                    if (response.body() != null)
                        makeAndPopulateSpinner(response.body());
                }
                @Override
                public void onFailure(Call<List<RestaurantUser>>  call, Throwable t) {
                    System.out.println("error in LoginDataSource:onFailure");
                }
            });


        //Initialize button and onclick to view the menu for that particular restaurant
        //create a bundle to send to the MenuActivity class with the intent (containing the restaurantClicked)
        Button button= findViewById(R.id.viewMenuButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle extras = new Bundle();
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                extras.putString("restaurantClicked", spinner.getSelectedItem().toString());
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        Button button2= findViewById(R.id.viewAccountButton);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle extras = new Bundle();
                Intent intent = new Intent(MainActivity.this, CustomerPageActivity.class);
                extras.putString("restaurantClicked", spinner.getSelectedItem().toString());
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

    }

    //Initialize Spinner and an ArrayAdapter for displaying values
    private void makeAndPopulateSpinner(List<RestaurantUser> restaurantUserList){
        String[] restaurantArray = new String[restaurantUserList.size()];
        for(int i = 0; i <restaurantUserList.size(); i++)
            restaurantArray[i] = restaurantUserList.get(i).getName();

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        restaurantArray); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
    }

}
