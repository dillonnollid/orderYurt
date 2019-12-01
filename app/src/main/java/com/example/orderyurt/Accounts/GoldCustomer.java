package com.example.orderyurt.Accounts;

public class GoldCustomer extends CustomerUser {

    private String customerType = "gold";

    public GoldCustomer(String customerName, String customerEmail){
        super(customerName,customerEmail);
    }

    @Override
    public String getCustomerType(){
        return customerType;
    }
}
