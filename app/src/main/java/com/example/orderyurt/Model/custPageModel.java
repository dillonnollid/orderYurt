package com.example.orderyurt.Model;

import com.example.orderyurt.Accounts.CustomerUser;
import com.example.orderyurt.Controllers.CustomerPageActivity;
import com.example.orderyurt.Discount.Coupon;

import java.util.ArrayList;

public class custPageModel {
    private CustomerUser cUser;
    private CustomerPageActivity delegate = null;
    private ArrayList<Coupon> coupons;

    /**
     * Constructor to get the CustomerUser we need.
     */
    public custPageModel(){
        this.cUser = new CustomerUser("","");
    }

    /**
     * Sets the delegate variable to d.
     * @param d is the instance of CustomerPageActivity that we need to use.
     */
    public void setDelegate(CustomerPageActivity d) {
        this.delegate = d;
    }

    /**
     * Logs the user out of the application. Re-directs the user to the login page.
     */
    public void logout(){
        //TODO: Logout functionality
        delegate.goToLoginActivity();
    }

    /**
     * Retrieves the logged in user's username and calls the delegate.setTitle function.
     */
    public void setUsername(){
        delegate.setTitle(this.cUser.getName());
    }


}
