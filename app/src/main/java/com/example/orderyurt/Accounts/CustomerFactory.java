package com.example.orderyurt.Accounts;

public class CustomerFactory {

    public CustomerUser getUser(String userType){

        if(userType == null){
            return null;
        }
        if(userType.equalsIgnoreCase("bronze")){
            return new BronzeCustomer();
        }
        else if(userType.equalsIgnoreCase("silver")){
            return new SilverCustomer();
        }
        else if(userType.equalsIgnoreCase("gold")){
            return new GoldCustomer();
        }

        return null;
    }
}
