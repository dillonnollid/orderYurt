package com.example.orderyurt.Accounts;

public class GoldCustomer extends CustomerUser {

    public GoldCustomer(){
        super();
    }

    private String customerType = "gold";

    public String getCustomerType(){
        return customerType;
    }
}
