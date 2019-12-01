package com.example.orderyurt.Order;

import com.example.orderyurt.Menu.Item;

import java.util.ArrayList;

public class Basket {
    private int customerId;
    private ArrayList<Item> items;
    private double cost;

    public Basket(int cId){
        this.customerId = cId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public double getCost() {
        return cost;
    }

    public void setCost() {
        double amount = 0.0;
        for(Item item: items){
            amount += item.getPrice();
        }
        this.cost = amount;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item itemToRemove){
        for(Item item: items){
            if(item.getName().equals(itemToRemove.getName())){
                items.remove(item);
            }
        }
    }
}
