package com.example.orderyurt.Controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.orderyurt.Controllers.R;
import com.example.orderyurt.Menu.Item;
import com.example.orderyurt.Order.Basket;
import com.example.orderyurt.Order.Order;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Basket b = new Basket(1);
        Order temp = new Order(b);
        ArrayList<Item> items = new ArrayList<>();//temp.getItems();
        items.add(new Item("Pasta", "Boom", 11.50));
        items.add(new Item("Pastazz", "Boom", 11.50));
        items.add(new Item("Pastazzzz", "Boom", 11.50));
        ArrayList<String> names = new ArrayList<>();//temp.getItems();
        for(int i=0; i < items.size(); i++){
            names.add(items.get(i).getName());
        }
        names.add("Wings");
        names.add("Burgers");
        //items.add(new Item("Pasta", "Boom", 11.50));
        ArrayAdapter mPairedDevicesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        ListView orderContents = (ListView) findViewById(R.id.basketList);
        orderContents.setAdapter(mPairedDevicesAdapter);

    }
}
