package com.example.orderyurt.Accounts;

public class GoldCustomer extends CustomerUser {

    private String customerType = "gold";

    /**
     * Constructor for GoldCustomer.
     * Takes in a customer name and email and passes them to the CustomerUser constructor.
     * @param customerName
     * @param customerEmail
     */
    public GoldCustomer(String customerName, String customerEmail){
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
