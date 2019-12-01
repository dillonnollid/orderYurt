package com.example.orderyurt.Model;


import com.example.orderyurt.Accounts.RestaurantUser;
import com.example.orderyurt.Discount.Coupon;
import com.example.orderyurt.Controllers.CreateCouponActivity;

import java.util.Date;

public class addCouponModel {
    private RestaurantUser rUser;
    private Coupon newCoupon;
    private CreateCouponActivity delegate = null;

    /**
     * Constructor to get the RestaurantUser we need.
     */
    public addCouponModel(){
        this.rUser = new RestaurantUser();
    }

    /**
     * Sets the delegate variable to d.
     * @param d is the instance of CreateCouponActivity that we need to use.
     */
    public void setDelegate(CreateCouponActivity d) {
        this.delegate = d;
    }

    /**
     * Creates a new coupon and notifies all the restaurants subscribers. Navigates the user to back
     * to the RestaurantPageActivity.
     * @param title is the coupon title.
     * @param code is the coupon code.
     * @param value is the coupon value (how much money off)
     * @param sDate is the start date.
     * @param eDate is the end date.
     */
    public void createCoupon(String title, String code, Double value, Date sDate, Date eDate){
        int ID = rUser.getID();
        newCoupon = new Coupon(title, code, value, sDate, eDate, ID);
        rUser.notifySubscribers(newCoupon);
        delegate.goToRestPageActivity();
    }


}
