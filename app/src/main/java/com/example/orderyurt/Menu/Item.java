package com.example.orderyurt.Menu;

public class Item {
    private int itemID;
    private String itemName;
    private String itemDescription;
    private Double itemPrice;

    public Item(String itemName, String itemDescription, Double itemPrice){
        this.itemName           = itemName;
        this.itemDescription    = itemDescription;
        this.itemPrice          = itemPrice;
    }
    public String getName(){
        return this.itemName;
    }

    public Double getPrice(){
        return this.itemPrice;
    }

    public String getItemDescription(){
        return this.itemDescription;
    }
}
