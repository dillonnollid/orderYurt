package com.example.orderyurt.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BasketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        ListView basketList = (ListView) findViewById(R.id.basketList);
        TextView totalCost = (TextView) findViewById(R.id.totalCostText);

    }
}
