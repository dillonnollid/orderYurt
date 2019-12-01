package com.example.orderyurt.Accounts;

import com.example.orderyurt.Discount.Coupon;

import java.util.ArrayList;

public class CustomerUser implements User, Subscriber{
    private int customerID;
    private String customerName;
    private String customerEmail;
    private ArrayList<Coupon> coupons;

    public CustomerUser(String customerName, String customerEmail){
        this.customerName  = customerName;
        this.customerEmail = customerEmail;
    }

    @Override
    public void update(Coupon coupon){
        if(!coupons.contains(coupon)) {
            this.coupons.add(coupon);
        }
    }

    public String getCustomerType(){
        return "default";
    }

    @Override
    public String getName() {
        return customerName;
    }

    @Override
    public String getEmail() {
        return customerEmail;
    }

    @Override
    public int getID() {
        return customerID;
    }

    @Override
    public void setID(int ID) {
        this.customerID = ID;
    }
}
