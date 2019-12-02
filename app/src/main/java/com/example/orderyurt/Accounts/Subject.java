package com.example.orderyurt.Accounts;

import com.example.orderyurt.Discount.Coupon;

public interface Subject {

    void addSubscriber(Subscriber subscriber);

    void removeSubscriber(Subscriber subscriber);

    void notifySubscribers(Coupon coupon);

}