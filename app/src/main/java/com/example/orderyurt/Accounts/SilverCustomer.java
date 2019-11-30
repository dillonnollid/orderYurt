package com.example.orderyurt.Accounts;

public class SilverCustomer extends CustomerUser {

    private String customerType = "silver";

    public SilverCustomer(){
        super();
    }

    @Override
    public String getCustomerType(){
        return customerType;
    }
}
