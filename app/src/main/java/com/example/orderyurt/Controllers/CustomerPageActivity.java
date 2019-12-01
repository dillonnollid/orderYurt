package com.example.orderyurt.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.orderyurt.Login.LoginActivity;
import com.example.orderyurt.Model.DelegateInterfaces;
import com.example.orderyurt.Model.custPageModel;

public class CustomerPageActivity extends AppCompatActivity implements DelegateInterfaces.custPageModelDelegate {
    Button subBtn, logoutBtn;
    TextView profileName;
    private custPageModel model = new custPageModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_page);

        logoutBtn   = findViewById(R.id.logoutBtn);
        subBtn      = findViewById(R.id.subsBtn);
        profileName = findViewById(R.id.textViewPP);

        model.setDelegate(this);
        model.setUsername();
    }

    /**
     * This method calls the logout function in the model class.
     * Shows the user a success message.
     * */
    public void logoutBtnClicked(View view) {
        model.logout();
        Toast.makeText(CustomerPageActivity.this, "Logging out.",
                Toast.LENGTH_LONG).show();
    }

    /**
     * This method navigates the user to the ViewSubscriberActivity
     * */
    @Override
    public void goToSubscriberActivity(View view){
        Intent myIntent = new Intent(CustomerPageActivity.this, ViewSubscriberActivity.class);
        CustomerPageActivity.this.startActivity(myIntent);
    }

    /**
     * This method navigates the user to the LoginActivity
     * */
    @Override
    public void goToLoginActivity(){
        Intent myIntent = new Intent(CustomerPageActivity.this, LoginActivity.class);
        CustomerPageActivity.this.startActivity(myIntent);
        finish();
    }

    /**
     * This method sets the title of the users profile page to their name.
     * */
    @Override
    public void setTitle(String name){
        profileName.setText(name);
    }

}
