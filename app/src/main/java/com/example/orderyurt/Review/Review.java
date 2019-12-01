package com.example.orderyurt.Review;

public class Review {
    private String reviewTitle;
    private String reviewDescription;
    private float rating;

    public Review(String title, String description, float rate){
        this.reviewTitle = title;
        this.reviewDescription = description;
        this.rating = rate;
    }

    public String getReviewTitle(){
        return reviewTitle;
    }

    public String getReviewDescription(){
        return reviewDescription;
    }

    public float getReviewRating(){
        return rating;
    }
}
