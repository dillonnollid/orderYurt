package com.example.orderyurt.Accounts;

public class CustomerFactory {

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
