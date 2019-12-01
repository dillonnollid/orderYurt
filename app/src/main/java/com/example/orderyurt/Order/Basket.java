package com.example.orderyurt.Order;

import com.example.orderyurt.Menu.Item;

import java.util.ArrayList;

public class Basket {
    private int customerId;
    private ArrayList<Item> items;
    private double cost;

    /**
     * Constructor for a new Basket.
     * Takes in the customer id and assigns it.
     * @param cId
     */
    public Basket(int cId){
        this.customerId = cId;
    }

    /**
     * @return customer id.
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Takes in a customer id which it assigns to the basket.
     * @param customerId
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * @return an arrayList of the basket's items.
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Takes in an arrayList of items and assigns it to the basket's items.
     * @param items
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * @return the cost of the basket.
     */
    public double getCost() {
        return cost;
    }

    /**
     * When called it iterates through the items in the basket, adding up all the prices of the items.
     * It then assigns these added up prices to the basket's cost.
     */
    public void setCost() {
        double amount = 0.0;
        for(Item item: items){
            amount += item.getPrice();
        }
        this.cost = amount;
    }

    /**
     * Takes in an item and adds it to the basket's items arrayList.
     * @param item
     */
    public void addItem(Item item){
        items.add(item);
    }

    /**
     * Takes in an item. It iterates through the arrayList of items, and if the item to remove matches
     * one of the items in the arrayList, it is removed.
     * @param itemToRemove
     */
    public void removeItem(Item itemToRemove){
        for(Item item: items){
            if(item.getName().equals(itemToRemove.getName())){
                items.remove(item);
            }
        }
    }
}
