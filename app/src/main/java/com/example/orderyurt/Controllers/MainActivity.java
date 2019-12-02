package com.example.orderyurt.Controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

//TODO: ADD MVC!!
/**
 * The MainActivity method displays a list of restaurants to the User with a Spinner
 * The User can choose the participating restaurant where they wish to dine by clicking the view menu button.
 * @spinner object will hold our Restaurant names and the restaurant chosen
 * @restaurantArray contains participating restaurants
 * @spinnerArrayAdapter allows Spinner onClick actions
 * **/
public class MainActivity extends AppCompatActivity {
    //Show list of restaurants
    //Show list of tables for specified restaurant

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner spinner = findViewById(R.id.spinner);

        //Initialize Spinner and an ArrayAdapter for displaying values
        String[] restaurantArray = new String[]{"Lana", "Jet's Pizza", "Camile", "La Cucina", "Brew Bros.", "Milano"};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        restaurantArray); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);

        //Initialize button and onclick to view the menu for that particular restaurant
        //create a bundle to send to the MenuActivity class with the intent (containing the restaurantClicked)
        Button button= findViewById(R.id.viewMenuButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle extras = new Bundle();
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                extras.putString("restaurantClicked", spinner.getSelectedItem().toString());
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        Button button2= findViewById(R.id.viewAccountButton);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle extras = new Bundle();
                Intent intent = new Intent(MainActivity.this, CustomerPageActivity.class);
                extras.putString("restaurantClicked", spinner.getSelectedItem().toString());
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

    }
}
