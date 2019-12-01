package com.example.orderyurt.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class EditMenuActivity extends AppCompatActivity {
    private Button addItemBtn;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_menu);

        addItemBtn  = findViewById(R.id.addItemBtn);
        listview    =  findViewById(R.id.listView2);

        /*
         * Sets up a listview of the items on the current restaurantUsers menu.
         * Makes each item clickable and opens the EditItemActivity when an item is selected.
         */
        AdapterView.OnItemClickListener cl = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> l, View v, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(EditMenuActivity.this, EditItemActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        };
        listview.setOnItemClickListener(cl);

        /*
         * Sets up an onClick listener for the addItemBtn.
         * Navigates the user to the AddItemActivity onClick.
         */
        addItemBtn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent myIntent = new Intent(EditMenuActivity.this, AddItemActivity.class);
                        EditMenuActivity.this.startActivity(myIntent);
                    }
                });
    }
}
