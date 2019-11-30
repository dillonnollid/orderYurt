package com.example.orderyurt.Menu;

import java.util.ArrayList;

public class Menu {
    private String menuID;
    private ArrayList<Item> items;

    public Menu(){
        items = new ArrayList<Item>();
    }

    public void addItem( Item itemID ){
        items.add(itemID);
    }

    public ArrayList<Item> getItems(){
        return items;
    }
}

