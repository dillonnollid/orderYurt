package com.example.orderyurt.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.orderyurt.Accounts.CustomerUser;
import com.example.orderyurt.Accounts.RestaurantUser;
import com.example.orderyurt.Accounts.Subscriber;


public class ViewRestaurantPageActivity extends AppCompatActivity {

    //This is a random user object, need to get the logged in user
    Subscriber user = new CustomerUser();

    //Need to get the restaurant based on which restaurant page we are on
    RestaurantUser rUser = new RestaurantUser();

    private Button subscribeBtn, menuBtn, unSubscribeBtn;
    private TextView restPage;

    private String rest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_rest_page);

        subscribeBtn = findViewById(R.id.subBtn);
        menuBtn = findViewById(R.id.menuBtn1);
        unSubscribeBtn = findViewById(R.id.unSubBtn);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        rest = b.getString("restName");

        restPage = (TextView) findViewById(R.id.restPage);
        restPage.setText(rest);




        /*
          Return to menu if menu button is clicked.
         */
        menuBtn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent myIntent = new Intent(ViewRestaurantPageActivity.this, MenuActivity.class);
                        myIntent.putExtra("restaurantClicked", rest); //Optional parameters
                        ViewRestaurantPageActivity.this.startActivity(myIntent);
                    }
                });

        /*
          Utilising Observer Design Pattern.
          Add subscriber to this restaurants subscriber ArrayList.
         */
        subscribeBtn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        rUser.addSubscriber(user);
                        subscribeBtn.setVisibility(View.GONE);
                        unSubscribeBtn.setVisibility(View.VISIBLE);
                    }
                });

        /*
          Utilising Observer Design Pattern.
          Remove subscriber to this restaurants subscriber ArrayList.
         */
        unSubscribeBtn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        rUser.removeSubscriber(user);
                        subscribeBtn.setVisibility(View.VISIBLE);
                        unSubscribeBtn.setVisibility(View.GONE);
                    }
                });
    }
}
