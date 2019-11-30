package com.example.orderyurt.Accounts;

public class GoldCustomer extends CustomerUser {

    private String customerType = "gold";

    public GoldCustomer(){
        super();
    }

    @Override
    public String getCustomerType(){
        return customerType;
    }
}
