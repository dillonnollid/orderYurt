package com.example.orderyurt.Accounts;

public class BronzeCustomer extends CustomerUser {

    private String customerType = "bronze";

    /**
     * Constructor for BronzeCustomer.
     * Takes in a customer name and email and passes them to the CustomerUser constructor.
     * @param customerName
     * @param customerEmail
     */
    public BronzeCustomer(String customerName, String customerEmail){
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