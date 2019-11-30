package com.example.orderyurt.Accounts;

public class BronzeCustomer extends CustomerUser {

    private String customerType = "bronze";

    public BronzeCustomer(){
        super();
    }

    @Override
    public String getCustomerType(){
        return customerType;
    }
}
