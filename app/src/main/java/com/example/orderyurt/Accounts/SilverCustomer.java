package com.example.orderyurt.Accounts;

public class SilverCustomer extends CustomerUser {

    private String customerType = "silver";

    /**
     * Constructor for SilverCustomer.
     * Takes in a customer name and email and passes them to the CustomerUser constructor.
     * @param customerName
     * @param customerEmail
     */
    public SilverCustomer(String customerName, String customerEmail){
        super(customerName,customerEmail);
    }

    /**
     * Overrides the method in CustomerUser.
     * @return the customer type.
     */
    @Override
    public String getCustomerType(){
        return customerType;
    }
}