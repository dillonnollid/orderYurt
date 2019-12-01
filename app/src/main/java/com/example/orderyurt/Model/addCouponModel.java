package com.example.orderyurt.Model;

import com.example.orderyurt.Accounts.RestaurantUser;
import com.example.orderyurt.Discount.Coupon;
import com.example.orderyurt.Controllers.CreateCouponActivity;

import java.util.Date;

public class addCouponModel {
    private RestaurantUser rUser;
    private Coupon newCoupon;
    private CreateCouponActivity delegate = null;

    public addCouponModel(){
        this.rUser = new RestaurantUser();
    }

    //Sets the delegate to the instance of AddItemActivity that we need
    public void setDelegate(CreateCouponActivity d) {
        this.delegate = d;
    }

    //TODO: Make an email go out to all the subscribers.
    public void createCoupon(String title, String code, Double value, Date sDate, Date eDate, int RID){
        newCoupon = new Coupon(title, code, value, sDate, eDate, RID);
        rUser.notifySubscribers(newCoupon);
        delegate.goToRestPageActivity();
    }

}
