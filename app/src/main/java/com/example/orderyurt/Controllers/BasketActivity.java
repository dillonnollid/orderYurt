package com.example.orderyurt.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BasketActivity extends AppCompatActivity {
    //View Basket - show array of items selected by user
    //Delete Item
    //Calculate cost
    //Go To PayActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        String [] items = b.getStringArray("items");
        String line="";
        final String rest = b.getString("restName"), temp;
        final double price = i.getDoubleExtra("totalprice", 0.0);
        //ListView basketList = (ListView) findViewById(R.id.basketList);
        TextView totalCost = (TextView) findViewById(R.id.totalCostText);
        totalCost.setText("Your order from " + rest + "\nTotal price of basket is " + String.valueOf(price));
        TextView basketContents = findViewById(R.id.basketContents);

        for(int j=0; j < items.length; j++){
            if(items[j] != null) {
                line += items[j] + "\n";
            }
        }
        basketContents.setText(line);
        temp = line;


        Button order = (Button) findViewById(R.id.payButton);
        order.setText("Order Now");
        order.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent myIntent = new Intent(BasketActivity.this, OrderActivity.class);
                        myIntent.putExtra("restName", rest); //Optional parameters
                        myIntent.putExtra("orderList", temp);
                        myIntent.putExtra("totalprice", price);
                        BasketActivity.this.startActivity(myIntent);
                    }
                });
    }
}
