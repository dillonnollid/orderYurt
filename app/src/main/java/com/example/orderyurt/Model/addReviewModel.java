package com.example.orderyurt.Model;

import com.example.orderyurt.Accounts.RestaurantUser;
import com.example.orderyurt.Controllers.AddReviewActivity;
import com.example.orderyurt.Review.Review;

public class addReviewModel {
    private RestaurantUser rUser;
    private Review newReview;

    private AddReviewActivity delegate = null;

    /**
     * Constructor to get the RestaurantUser we need.
     */
    public addReviewModel() {
        this.rUser = new RestaurantUser();
    }

    /**
     * Sets the delegate variable to d.
     * @param d is the instance of AddReviewActivity that we need to use.
     */
    public void setDelegate(AddReviewActivity d) {
        this.delegate = d;
    }

    /**
     * Creates a new Review Object and adds it to the RestaurantUser's ArrayList of reviews.
     * Navigates the user back to the EditMenuActivity.
     * @param title is the review title written by the user.
     * @param desc is the review contents.
     * @param rating is the star rating given by the user.
     */
    public void addReview(String title, String desc, float rating){
        newReview = new Review(title, desc, rating);
        rUser.addReview(newReview);
        delegate.goToViewRestPageActivity();
    }
}