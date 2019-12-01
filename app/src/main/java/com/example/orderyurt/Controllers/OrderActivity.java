package com.example.orderyurt.Controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
        Intent i = getIntent();
        Bundle b = i.getExtras();
        String items = b.getString("orderList");
        Double price = b.getDouble("totalprice");

        TextView contents = findViewById(R.id.basketList);
        TextView basketPrice = findViewById(R.id.basketPrice);
        basketPrice.setText("Total cost of basket is " + String.valueOf(price));
        contents.setText(items);

    }
}
