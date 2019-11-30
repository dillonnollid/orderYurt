package com.example.orderyurt.UserInterface;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.orderyurt.Accounts.RestaurantUser;
import com.example.orderyurt.Discount.Coupon;
import com.example.orderyurt.Menu.Item;

public class AddItemActivity extends AppCompatActivity {
    private String itemName, itemDesc;
    private Double itemPrice;
    private Item newItem;
    private RestaurantUser rUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        rUser = new RestaurantUser();
        Button addItemBtn;
        EditText name, desc, price;

        addItemBtn  = findViewById(R.id.addItemBtn1);
        name        = findViewById(R.id.itemName);
        desc        = findViewById(R.id.itemDesc);
        price       = findViewById(R.id.itemPrice);


        itemName    = name.getText().toString();
        itemDesc    = desc.getText().toString();

        String v    = price.getText().toString();
        if (!v.isEmpty()) {
            try {
                itemPrice = Double.parseDouble(v);
                // it means it is double
            } catch (Exception e1) {
                // this means it is not double
                e1.printStackTrace();
            }
        }

        //Creates a new item and adds it to the Menu
        addItemBtn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        newItem = new Item(itemName,itemDesc,itemPrice);
                        rUser.getMenu().addItem(newItem);

                        Toast.makeText(AddItemActivity.this, "Item Added.",
                                Toast.LENGTH_LONG).show();

                        Intent myIntent = new Intent(AddItemActivity.this, EditMenuActivity.class);
                        AddItemActivity.this.startActivity(myIntent);
                    }
                });

    }

}
