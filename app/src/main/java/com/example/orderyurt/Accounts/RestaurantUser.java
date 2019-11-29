package com.example.orderyurt.Accounts;

import com.example.orderyurt.Discount.Coupon;

import java.util.ArrayList;

public class RestaurantUser implements User, Subject{
    private ArrayList<Subscriber> subscribers;
    private String address;
    private String name;
    private int [] tables;

    public RestaurantUser(){
        subscribers = new ArrayList<Subscriber>();
    }

    @Override
    public void addSubscriber(Subscriber subscriber){
        if(!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    @Override
    public void removeSubscriber(Subscriber subscriber){
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Coupon coupon){
        for(Subscriber subscriber : this.subscribers){
            subscriber.update(coupon);
        }
    }

    public boolean checkIfSubscriberExists(Subscriber subscriber){
        boolean flag = false;
        if(this.subscribers.contains(subscriber)) {
            flag = true;
        }
        return flag;
    }

    public boolean checkIfSubscribersIsEmpty(){
        return this.subscribers.size() == 0;
    }
}
