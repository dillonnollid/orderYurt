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

//TODO: Create a customer page
public class CustomerPageActivity extends AppCompatActivity implements DelegateInterfaces.custPageModelDelegate {
    Button subBtn, logoutBtn, couponBtn;
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

    public void logoutBtnClicked(View view) {
        model.logout();
        Toast.makeText(CustomerPageActivity.this, "Logging out.",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void goToSubscriberActivity(View view){
        Intent myIntent = new Intent(CustomerPageActivity.this, ViewSubscriberActivity.class);
        CustomerPageActivity.this.startActivity(myIntent);
    }

    @Override
    public void goToLoginActivity(){
        Intent myIntent = new Intent(CustomerPageActivity.this, LoginActivity.class);
        CustomerPageActivity.this.startActivity(myIntent);
        finish();
    }

    @Override
    public void setTitle(String name){
        profileName.setText(name);
    }

}
