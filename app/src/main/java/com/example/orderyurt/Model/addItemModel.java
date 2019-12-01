package com.example.orderyurt.Model;

import com.example.orderyurt.Accounts.RestaurantUser;
import com.example.orderyurt.Menu.Item;
import com.example.orderyurt.Menu.Menu;
import com.example.orderyurt.Controllers.AddItemActivity;
//delegation when you pass the task of an object to another one

public class addItemModel {
    private RestaurantUser rUser;
    private Menu menu;
    private Item newItem;
    private AddItemActivity delegate = null;

    /**
     * Constructor to get the RestaurantUser and Menu objects we need.
     */
    public addItemModel(){
        this.rUser = new RestaurantUser();
        this.menu = rUser.getMenu();
    }

    /**
     * Sets the delegate variable to d.
     * @param d is the instance of AddItemActivity that we need to use.
     */
    public void setDelegate(AddItemActivity d) {
        this.delegate = d;
    }

    /**
     * Creates a new Item Object and adds it to the menu of the logged in RestaurantUser.
     * Navigates the user back to the EditMenuActivity.
     * @param name is the item name.
     * @param desc is the description of the item.
     * @param price is the item cost price.
     */
    public void addItem(String name, String desc, Double price) {
        newItem = new Item(name, desc, price);
        menu.addItem(newItem);
        delegate.goToEditMenuActivity();
    }
}
