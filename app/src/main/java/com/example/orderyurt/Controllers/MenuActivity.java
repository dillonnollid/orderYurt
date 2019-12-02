package com.example.orderyurt.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//TODO: ADD MVC!!

/**
 * MenuActivity displays a restaurants menu Items to the users,
 * When a user clicks an item from the ListView, the item name is added to an array
 * When the user is ready to view their order they can click the Order button
 * And will be redirected to the OrderActivity, sending the required variables with a bundle
 * @itemNames is used to store the String names of the items requested (Arraylist can't be added to bundle)
 * @counter keeps track of how many items have been added to the array
 * @b (bundle) is sent with the Intent to the next Activity
 * @rest stores the name of the restaurant that was clicked by the user in the previous activity
 * @restPageBtn is used to bring us to the restaurant clicked's page
 * @orderButton will create a new intent when clicked and will send the itemNames to the Order activity
 * @listview combined with @c1 (AdapterView) are used to display items and add items to the itemNames array
 */
public class MenuActivity extends AppCompatActivity {
    String rest = "";
    String [] itemNames = new String[30];
    int counter = 0;
    double price=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent i = getIntent();
        Bundle b = i.getExtras();

        rest = b.getString("restaurantClicked");

        Toast.makeText(MenuActivity.this, rest,
                Toast.LENGTH_LONG).show();
        TextView currentRest;
        currentRest = (TextView) findViewById(R.id.menuTitle);;
        currentRest.setText(rest);

        Button restPageBtn = findViewById(R.id.restPageBtn);
        Button orderButton = findViewById(R.id.orderButton);


        ListView listview = (ListView) findViewById(R.id.listView1);
        AdapterView.OnItemClickListener cl = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> l, View v, int position, long id) {
                //Log.i("MenuListView", "You clicked Item: " + id + " at position:" + position);
                itemNames[counter] = String.valueOf(l.getItemAtPosition(position));//String.valueOf(itemNames[position]);
                counter++;
                price = price + 6.50;

            }
        };
        listview.setOnItemClickListener(cl);


        restPageBtn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent myIntent = new Intent(MenuActivity.this, ViewRestaurantPageActivity.class);
                        myIntent.putExtra("restName", rest); //Optional parameters
                        MenuActivity.this.startActivity(myIntent);
                    }
                });

        orderButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        Intent myIntent = new Intent(MenuActivity.this, BasketActivity.class);
                        myIntent.putExtra("restName", rest); //Optional parameters
                        myIntent.putExtra("totalprice", price);
                        bundle.putStringArray("items",itemNames);
                        myIntent.putExtras(bundle);
                        MenuActivity.this.startActivity(myIntent);
                    }
                });
    }

}