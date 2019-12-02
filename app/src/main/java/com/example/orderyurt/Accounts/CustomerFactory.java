package com.example.orderyurt.Accounts;

public class CustomerFactory {

    /**
     * Implements the factory method to instantiate different type of customers.
     * Takes in the name and email to be used in the constructor of the new customer.
     * Also takes in the type as a string which will be either bronze, silver or gold.
     * When a type matches the condition a new customer od that type is instantiated.
     * @param name
     * @param email
     * @param userType
     * @return the new customer of the specified type.
     */
    public CustomerUser getUser(String name, String email, String userType){

        if(userType == null){
            return null;
        }
        if(userType.equalsIgnoreCase("bronze")){
            return new BronzeCustomer(name, email);
        }
        else if(userType.equalsIgnoreCase("silver")){
            return new SilverCustomer(name, email);
        }
        else if(userType.equalsIgnoreCase("gold")){
            return new GoldCustomer(name, email);
        }
        return null;
    }
}
