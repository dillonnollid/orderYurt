package com.example.orderyurt.UserInterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.orderyurt.R;

public class MainActivity extends AppCompatActivity {
    //Show list of restaurants
    //Show list of tables for specified restaurant

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String restaurantArray[] = new String[]{"Lana", "Jet's Pizza", "Camile", "La Cucina", "Brew Bros."};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        restaurantArray); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);

        Button button= (Button) findViewById(R.id.viewMenuButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
    }
}
