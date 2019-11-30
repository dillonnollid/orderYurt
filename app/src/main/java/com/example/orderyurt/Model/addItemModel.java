package com.example.orderyurt.Model;

import com.example.orderyurt.Accounts.RestaurantUser;
import com.example.orderyurt.Menu.Item;
import com.example.orderyurt.Menu.Menu;
import com.example.orderyurt.UserInterface.AddItemActivity;

public class addItemModel {
    private RestaurantUser rUser;
    private Menu menu;
    private Item newItem;
    public AddItemActivity delegate = null;

    public addItemModel(){
        this.rUser = new RestaurantUser();
        this.menu = new Menu();
    }

    //Sets the delegate to the instance of AddItemActivity that we need
    public void setDelegate(AddItemActivity d) {
        delegate = d;
    }

    //delegation when you pass the task of an object to another one
    public void addItem(String name, String desc, Double price) {
        newItem = new Item(name, desc, price);
        menu.addItem(newItem);
        delegate.goToEditMenuActivity();
    }
}
