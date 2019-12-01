package com.example.orderyurt.Accounts;

public class BronzeCustomer extends CustomerUser {

    private String customerType = "bronze";

    public BronzeCustomer(String customerName, String customerEmail){
        super(customerName,customerEmail);
    }

    @Override
    public String getCustomerType(){
        return customerType;
    }
}
