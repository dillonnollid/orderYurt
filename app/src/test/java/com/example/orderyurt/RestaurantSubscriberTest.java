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
    ArrayList<Coupon> coupons;



    @Before
    public void setUp() throws Exception{

        restaurant = new RestaurantUser();
        factory = new CustomerFactory();
        customer = factory.getUser("benjamin", "test@gmail.com", "gold");
    }

    @Test
    public void restaurantUser_makeNewSubscriber() {

        restaurant.addSubscriber(customer);
        ArrayList<Subscriber> subs = restaurant.getSubscribers();
        assertEquals(subs.get(0), customer);
    }

    @Test
    public void restaurantUser_removeASubscriber() {

        restaurant.addSubscriber(customer);
        ArrayList<Subscriber> subs = restaurant.getSubscribers();
        restaurant.removeSubscriber(customer);
        assertEquals(subs.size(), 0);
    }
}
