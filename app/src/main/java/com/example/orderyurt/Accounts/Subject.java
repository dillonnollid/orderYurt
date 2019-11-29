package com.example.orderyurt.Accounts;

public interface Subject {

    void addSubscriber(Subscriber subscriber);

    void removeSubscriber(Subscriber subscriber);

    public void notifySubscribers();

}
