package com.example.orderyurt.Accounts;

import com.example.orderyurt.Discount.Coupon;

public interface Subject {

    void addSubscriber(Subscriber subscriber);

    void removeSubscriber(Subscriber subscriber);

    public void notifySubscribers(Coupon coupon);

}
