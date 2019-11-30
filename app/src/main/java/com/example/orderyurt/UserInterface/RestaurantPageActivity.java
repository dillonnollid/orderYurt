package com.example.orderyurt.UserInterface;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RestaurantPageActivity extends AppCompatActivity {
    //Check who is signed in .. If its a customer account then show the following
    //Name, Address, Subscribe button, Menu button, Read reviews button, Add reviews button

    //If it is the restaurant page of the restaurant user who is logged in
    //Allow them to edit info and edit/create menu
    //Show name, address, menu button, reviews button, list of subscribers

    Button   couponBtn, menuBtn;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_page);

        couponBtn = findViewById(R.id.couponBtn);
        menuBtn   = findViewById(R.id.menuBtn);
        name      = findViewById(R.id.name);

        couponBtn.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Intent myIntent = new Intent(RestaurantPageActivity.this, CreateCouponActivity.class);
                        //myIntent.putExtra("key", value); //Optional parameters
                        RestaurantPageActivity.this.startActivity(myIntent);
                    }
                });

        menuBtn.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Intent myIntent = new Intent(RestaurantPageActivity.this, EditMenuActivity.class);
                        RestaurantPageActivity.this.startActivity(myIntent);
                    }
                });

    }
}
