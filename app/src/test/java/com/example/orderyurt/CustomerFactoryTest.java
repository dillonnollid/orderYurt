package com.example.orderyurt;

import com.example.orderyurt.Accounts.CustomerFactory;
import com.example.orderyurt.Accounts.CustomerUser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerFactoryTest {

    /**
    * Creates a new CustomerFactory. It the uses the factory to create a new silver customer by
    * creating a regular customer and passing the string "silver" into the getUser method in the factory.
    * It the asserts that the customer type of that new customer is set to silver.
     */
    @Test
    public void canCreateCustomerUser(){
        CustomerFactory factory = new CustomerFactory();
        CustomerUser silverCustomer = factory.getUser("adam", "test@gmail.com", "silver");
        String result = silverCustomer.getCustomerType();

        assertEquals(result, "silver");
    }
}
