package com.example.orderyurt;

import com.example.orderyurt.Accounts.CustomerFactory;
import com.example.orderyurt.Accounts.CustomerUser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerFactoryTest {

    //Test that when a new SilverCustomer is created using the CustomerFactory that the customerType is set to silver.
    @Test
    public void canCreateCustomerUser(){
        CustomerFactory factory = new CustomerFactory();
        CustomerUser silverCustomer = factory.getUser("silver");
        String result = silverCustomer.getCustomerType();

        assertEquals(result, "silver");
    }
}
