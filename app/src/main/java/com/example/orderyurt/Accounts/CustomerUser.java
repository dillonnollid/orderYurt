package com.example.orderyurt.Accounts;

import com.example.orderyurt.Discount.Coupon;

import java.util.ArrayList;

public class CustomerUser implements User, Subscriber{
    private int customerID;
    private String customerName;
    private ArrayList<Coupon> coupons;

    public CustomerUser(){

    }

    @Override
    public void update(Coupon coupon){
        if(!coupons.contains(coupon)) {
            this.coupons.add(coupon);
        }
    }

    public void setCustomerID(int cID){
        this.customerID = cID;
    }

    public int getCustomerID(){
        return this.customerID;
    }

    public void setCustomerName(String cName){
        this.customerName = cName;
    }

    public String getCustomerName(){
        return this.customerName;
    }
}
