package com.example.orderyurt.Model;

import com.example.orderyurt.Accounts.RestaurantUser;
import com.example.orderyurt.Controllers.AddReviewActivity;
import com.example.orderyurt.Review.Review;

public class addReviewModel {
    private RestaurantUser rUser = new RestaurantUser();
    private Review newReview;

    private AddReviewActivity delegate = null;

    public addReviewModel() {
        this.rUser = new RestaurantUser();
    }

    //Sets the delegate to the instance of AddItemActivity that we need
    public void setDelegate(AddReviewActivity d) {
        this.delegate = d;
    }

    public void addReview(String title, String desc, float rating){
        newReview = new Review(title, desc, rating);
        delegate.goToViewRestPageActivity();
    }

}