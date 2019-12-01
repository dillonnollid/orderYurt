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
public class MenuActivity extends AppCompatActivity {
    String rest = "";
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


        ListView listview = (ListView) findViewById(R.id.listView1);
        AdapterView.OnItemClickListener cl = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> l, View v, int position, long id) {
                Log.i("HelloListView", "You clicked Item: " + id + " at position:" + position);

                Intent intent = new Intent();
                intent.setClass(MenuActivity.this, BasketActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("id", id);
                startActivity(intent);
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
    }

}
