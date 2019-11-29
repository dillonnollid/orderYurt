package com.example.orderyurt.Accounts;

import com.example.orderyurt.Discount.Coupon;

import java.util.ArrayList;

public class CustomerUser implements User, Subscriber{
    private int customerID;
    private String customerName;
    private ArrayList<Coupon> coupons;

    @Override
    public void update(Coupon coupon){
        if(!coupons.contains(coupon)) {
            this.coupons.add(coupon);
        }
    }
}
