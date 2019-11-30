package com.example.orderyurt.Accounts;

import com.example.orderyurt.Discount.Coupon;
import com.example.orderyurt.Menu.Menu;

import java.util.ArrayList;

public class RestaurantUser implements User, Subject{
    private ArrayList<Subscriber> subscribers;
    private String address;
    private String name;
    private int [] tables;
    private Menu menu;

    public RestaurantUser(){
        subscribers = new ArrayList<Subscriber>();
        menu        = new Menu();
    }

    public Menu getMenu(){
        return this.menu;
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

}
