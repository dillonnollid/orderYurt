package com.example.orderyurt.Accounts;

import com.example.orderyurt.Discount.Coupon;
import com.example.orderyurt.Menu.Item;
import com.example.orderyurt.Order.Basket;

import java.util.ArrayList;

public class CustomerUser implements User, Subscriber{
    private int customerID;
    private String customerName;
    private String customerEmail;
    private ArrayList<Coupon> coupons;
    private Basket basket;

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

    public void setBasket(){
        this.basket = new Basket(this.customerID);
    }

    public void addToBasket(Item item){
        this.basket.addItem(item);
    }

    public void removeItemInBasket(Item item){
        this.basket.removeItem(item);
    }

    public Basket getBasket(){
        return this.basket;
    }

    public ArrayList<Coupon> getCoupons(){
        return this.coupons;
    }
}
