package com.example.orderyurt.Accounts;

import com.example.orderyurt.Discount.Coupon;

import java.util.ArrayList;

public class RestaurantUser implements User, Subject{
    private ArrayList<Subscriber> subscribers;
    private String address;
    private String name;
    private int [] tables;
    private Coupon coupon;

    @Override
    public void addSubscriber(Subscriber subscriber){
        if(!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    @Override
    public void removeSubscriber(Subscriber subscriber){
        if(subscribers.contains(subscriber)) {
            subscribers.remove(subscriber);
        }
    }

    @Override
    public void notifySubscribers(){
        for(Subscriber subscriber : this.subscribers){
            subscriber.update(this.coupon);
        }
    }
}
