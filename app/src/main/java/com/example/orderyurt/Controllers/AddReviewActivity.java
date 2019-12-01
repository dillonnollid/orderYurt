package com.example.orderyurt.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.orderyurt.Accounts.RestaurantUser;
import com.example.orderyurt.Discount.Coupon;
import com.example.orderyurt.Review.Review;

public class AddReviewActivity extends AppCompatActivity {
    //Create a Review object and add it to DB for this restaurant
    RestaurantUser rUser = new RestaurantUser();
    Review newReview;
    Button addReviewButton;
    EditText title, description;
    String reviewTitle, reviewDescription;
    RatingBar ratingBar;
    float rating;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);

        addReviewButton = (Button) findViewById(R.id.addReviewButton);
        title = (EditText) findViewById(R.id.reviewTitle);
        description = (EditText) findViewById(R.id.reviewDescription);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        reviewTitle = title.getText().toString();
        reviewDescription = description.getText().toString();
        rating = ratingBar.getRating();

        addReviewButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        newReview = new Review(reviewTitle, reviewDescription, rating);
                        rUser.addReview(newReview);
                        Toast.makeText(AddReviewActivity.this, R.string.review_added,
                                Toast.LENGTH_LONG).show();

                        Intent myIntent = new Intent(AddReviewActivity.this, RestaurantPageActivity.class);
                        AddReviewActivity.this.startActivity(myIntent);
                    }
                });

    }
}
