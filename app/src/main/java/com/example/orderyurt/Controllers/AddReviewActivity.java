package com.example.orderyurt.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.orderyurt.Model.DelegateInterfaces;
import com.example.orderyurt.Model.addReviewModel;


public class AddReviewActivity extends AppCompatActivity implements DelegateInterfaces.addReviewModelDelegate {
    //Create a Review object and add it to DB for this restaurant
    private EditText title, description;
    private String reviewTitle, reviewDescription;
    private RatingBar ratingBar;
    private float rating;
    private addReviewModel model = new addReviewModel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);

        title = findViewById(R.id.reviewTitle);
        description = findViewById(R.id.reviewDescription);
        ratingBar = findViewById(R.id.ratingBar);

        reviewTitle = title.getText().toString();
        reviewDescription = description.getText().toString();
        rating = ratingBar.getRating();

        model.setDelegate(this);
    }

    public void addReviewBtnClicked(View view) {
        model.addReview(reviewTitle, reviewDescription, rating);
        Toast.makeText(AddReviewActivity.this, R.string.review_added,
                Toast.LENGTH_LONG).show();
    }

    /**
     * This method navigates the user back to the viewRestaurantPageActivity.
     * */
    @Override
    public void goToViewRestPageActivity(){
        Intent myIntent = new Intent(AddReviewActivity.this, ViewRestaurantPageActivity.class);
        AddReviewActivity.this.startActivity(myIntent);
        finish();
    }
}
