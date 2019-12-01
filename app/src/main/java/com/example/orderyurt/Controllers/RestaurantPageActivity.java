package com.example.orderyurt.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RestaurantPageActivity extends AppCompatActivity {

    private Button   couponBtn, menuBtn;
    private TextView name;

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
