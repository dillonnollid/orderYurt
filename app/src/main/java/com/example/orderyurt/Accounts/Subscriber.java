package com.example.orderyurt.Accounts;
import com.example.orderyurt.Discount.Coupon;

public interface Subscriber {

    /**
     *  Updates the observers with a new coupon and adds it to their account.
     *  @param coupon is the new coupon that will be added to their account.
     */
    public void update(Coupon coupon);

}