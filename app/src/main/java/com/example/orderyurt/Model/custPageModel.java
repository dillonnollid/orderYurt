package com.example.orderyurt.Model;

import com.example.orderyurt.Accounts.CustomerUser;
import com.example.orderyurt.Controllers.CustomerPageActivity;
import com.example.orderyurt.Discount.Coupon;

import java.util.ArrayList;

public class custPageModel {
    private CustomerUser cUser;
    private CustomerPageActivity delegate = null;
    private ArrayList<Coupon> coupons;

    public custPageModel(){
        this.cUser = new CustomerUser("","");
    }

    public void setDelegate(CustomerPageActivity d) {
        this.delegate = d;
    }

    public void logout(){
        //TODO: Logout functionality
        delegate.goToLoginActivity();
    }

    public void setUsername(){
        delegate.setTitle(this.cUser.getName());
    }


}
