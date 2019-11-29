package com.example.orderyurt.UserInterface;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

import com.example.orderyurt.Menu.Item;

public class MenuActivity extends AppCompatActivity {
    //Show list of items for this restaurant
    //Add item to basket
    //Go to basket
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //ArrayList<Item> items = new ArrayList<Item>();
        Intent i = getIntent();
        Bundle b = i.getExtras();
        String rest = b.getString("restaurantClicked");
        Toast.makeText(MenuActivity.this, rest,
                Toast.LENGTH_LONG).show();
        TextView currentRest;
        currentRest = (TextView) findViewById(R.id.textView2);;
        currentRest.setText("Menu For " + rest);


        ListView listview = (ListView) findViewById(R.id.listView1);
        AdapterView.OnItemClickListener cl = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> l, View v, int position, long id) {
                Log.i("HelloListView", "You clicked Item: " + id + " at position:" + position);
                // Then you start a new Activity via Intent
                Intent intent = new Intent();
                intent.setClass(MenuActivity.this, BasketActivity.class);
                intent.putExtra("position", position);
                // Or / And
                intent.putExtra("id", id);
                startActivity(intent);
            }
        };
        listview.setOnItemClickListener(cl);
    }

}
