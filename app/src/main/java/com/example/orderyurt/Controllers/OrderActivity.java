package com.example.orderyurt.Controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.orderyurt.Controllers.R;
import com.example.orderyurt.Menu.Item;
import com.example.orderyurt.Order.Basket;
import com.example.orderyurt.Order.Order;

import java.util.ArrayList;

/**
 * OrderActivity summarises the order and displays it's information to the user.
 * If the user is satisfied, they can click the Pay button to be brought to the PaymentActivity
 * @rest gets the restaurant name from the bundle, final so it can be used in Anonymous classes
 * @items gets the string containing the order items from the bundle
 * @price gets the total price of the order from the bundle
 * @contents displays the order list to the user
 * @basketPrice displays the total price to the user
 * @payButton creates an intent to go to PaymentActivity and attaches the relevant objects to the bundle
 */
public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        final String rest  = b.getString("restName");
        final String items = b.getString("orderList");
        final Double price = b.getDouble("totalprice");

        TextView contents = findViewById(R.id.basketList);
        TextView basketPrice = findViewById(R.id.basketPrice);
        basketPrice.setText("Total cost of basket is " + String.valueOf(price));
        contents.setText(items);

        Button payButton = findViewById(R.id.payButton);
        payButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent myIntent = new Intent(OrderActivity.this, PaymentActivity.class);
                        myIntent.putExtra("restName", rest); //Optional parameters
                        myIntent.putExtra("totalprice", price);
                        myIntent.putExtra("items", items);
                        OrderActivity.this.startActivity(myIntent);
            }
        });

    }
}
