package com.example.orderyurt.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.orderyurt.Model.DelegateInterfaces;
import com.example.orderyurt.Model.addItemModel;

public class AddItemActivity extends AppCompatActivity implements DelegateInterfaces.addItemModelDelegate {
    private String itemName, itemDesc;
    private Double itemPrice;

    private addItemModel model = new addItemModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        itemName    = ((EditText) findViewById(R.id.itemName)).getText().toString();
        itemDesc    = ((EditText) findViewById(R.id.itemDesc)).getText().toString();
        String price    = ((EditText) findViewById(R.id.itemPrice)).getText().toString();

        if (!price.isEmpty()) {
            try { itemPrice = Double.parseDouble(price); }
            catch (Exception e1) { e1.printStackTrace(); }
        }
        model.setDelegate(this);
    }


    /**
     * This method is called when the addItem button is clicked.
     * It passes the user input to the model class using the addItem method.
     * */
    public void addItemBtnClicked(View v) {
        model.addItem(itemName, itemDesc, itemPrice);
        Toast.makeText(AddItemActivity.this, "Item Added.", Toast.LENGTH_LONG).show();
    }

    /**
     * This method navigates the user back to the edit menu activity.
     * */
    @Override
    public void goToEditMenuActivity(){
        Intent myIntent = new Intent(AddItemActivity.this, EditMenuActivity.class);
        AddItemActivity.this.startActivity(myIntent);
        finish();
    }

}
