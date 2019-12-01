package com.example.orderyurt.Order;

import com.example.orderyurt.Menu.Item;

import java.util.ArrayList;

public class Order {
    private int customerId;
    private ArrayList<Item> items;
    private double total;

    public Order(Basket temp){
        this.items      = temp.getItems();
        this.customerId = temp.getCustomerId();
        this.total      = temp.getCost();

    }
    public double getOrderTotal(){
        return this.total;
    }
    public int getCustomerId(){
        return this.customerId;
    }
    public ArrayList<Item> getItems(){
        return this.items;
    }
}
