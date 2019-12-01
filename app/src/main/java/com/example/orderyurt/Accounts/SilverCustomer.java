package com.example.orderyurt.Accounts;

public class SilverCustomer extends CustomerUser {

    private String customerType = "silver";

    public SilverCustomer(String customerName, String customerEmail){
        super(customerName,customerEmail);
    }

    @Override
    public String getCustomerType(){
        return customerType;
    }
}
