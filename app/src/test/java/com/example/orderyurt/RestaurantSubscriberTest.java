package com.example.orderyurt;

import android.content.Context;

import com.example.orderyurt.Accounts.CustomerFactory;
import com.example.orderyurt.Accounts.CustomerUser;
import com.example.orderyurt.Accounts.RestaurantUser;
import com.example.orderyurt.Accounts.Subscriber;
import com.example.orderyurt.Controllers.CreateCouponActivity;
import com.example.orderyurt.Discount.Coupon;
import com.example.orderyurt.Model.addCouponModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class RestaurantSubscriberTest {

    private RestaurantUser restaurant;
    private CustomerFactory factory;
    private CustomerUser customer;
    ArrayList<Subscriber> subs;


    /**
     * Instantiates the restaurant, CustomerFactory and GoldCustomer.
     * Adds the customer as a new subscriber to the restaurant.
     * Instantiates the subs arrayList to hold all the restaurants subscribers.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception{

        restaurant = new RestaurantUser();
        factory = new CustomerFactory();
        customer = factory.getUser("benjamin", "test@gmail.com", "gold");
        restaurant.addSubscriber(customer);
        subs = restaurant.getSubscribers();
    }

    /**
     * Asserts that the customer is on the arrayList of subscribers, verifying
     * that the addSubscriber method is working.
     */
    @Test
    public void restaurantUser_makeNewSubscriber() {
        assertEquals(subs.get(0), customer);
    }

    /**
     * Calls the removeSubscriber method from the restaurant, passing in the customer.
     * This will remove the customer as a subscriber.
     * Asserts that the length of the subs arrayList is 0, verifying that the subscriber was removed.
     */
    @Test
    public void restaurantUser_removeASubscriber() {
        restaurant.removeSubscriber(customer);
        assertEquals(subs.size(), 0);
    }
}
