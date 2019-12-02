package com.example.orderyurt.Accounts;

import com.example.orderyurt.Discount.Coupon;
import com.example.orderyurt.Menu.Item;
import com.example.orderyurt.Order.Basket;

import java.util.ArrayList;

public class CustomerUser implements User, Subscriber{
    private int customerID;
    private String customerName;
    private String customerEmail;
    private ArrayList<Coupon> coupons;
    private Basket basket;

    /**
     * Instantiates the CustomerUser object, assigning the name and email.
     * @param customerName
     * @param customerEmail
     */
    public CustomerUser(String customerName, String customerEmail){
        this.customerName  = customerName;
        this.customerEmail = customerEmail;
    }

    /**
     * Updates the user with new coupons if they are subscribers of the restaurant who created the coupon.
     * @param coupon is the new coupon that will be added to their account.
     */
    @Override
    public void update(Coupon coupon){
        if(!coupons.contains(coupon)) {
            this.coupons.add(coupon);
        }
    }

    /**
     * Sets the default customer type. This method is overwritten in the bronze, silver and gold customer classes.
     * @return default type.
     */
    public String getCustomerType(){
        return "default";
    }

    /**
     * @return name of the customer.
     */
    @Override
    public String getName() {
        return customerName;
    }

    /**
     * @return email of the customer.
     */
    @Override
    public String getEmail() {
        return customerEmail;
    }

    /**
     * @return id of the customer.
     */
    @Override
    public int getID() {
        return customerID;
    }

    /**
     * Takes in an int and assigns it to the customer id.
     * @param ID
     */
    @Override
    public void setID(int ID) {
        this.customerID = ID;
    }

    /**
     * Creates a new basket for the customer.
     */
    public void setBasket(){
        this.basket = new Basket(this.customerID);
    }

    /**
     * Takes in an item and adds it to the customer's basket.
     * @param item
     */
    public void addToBasket(Item item){
        this.basket.addItem(item);
    }

    /**
     * Takes in an item and removes it from the customer's basket.
     * @param item
     */
    public void removeItemInBasket(Item item){
        this.basket.removeItem(item);
    }

    /**
     * @return customer's basket.
     */
    public Basket getBasket(){
        return this.basket;
    }

    /**
     * @return customer's coupons.
     */
    public ArrayList<Coupon> getCoupons(){
        return this.coupons;
    }
}