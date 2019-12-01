package com.example.orderyurt.Controllers;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.orderyurt.Model.DelegateInterfaces;
import com.example.orderyurt.Model.addCouponModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateCouponActivity extends AppCompatActivity implements DelegateInterfaces.addCouponModelDelegate {

    private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private Date eDate, sDate;
    private Double  cValue = 0.0;
    private String cCode, cTitle;
    private addCouponModel model = new addCouponModel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_coupon);

        EditText value, startDate, endDate;
        cTitle      = ((EditText) findViewById(R.id.title)).getText().toString();
        cCode       = ((EditText) findViewById(R.id.code)).getText().toString();

        value       = findViewById(R.id.value);
        startDate   = findViewById(R.id.startDate);
        endDate     = findViewById(R.id.endDate);

        String v    = value.getText().toString();
        if (!v.isEmpty()) {
            try { cValue = Double.parseDouble(v); }
            catch (Exception e1) { e1.printStackTrace(); }
        }

        try {
            String d1   = startDate.getText().toString();
            String d2   = endDate.getText().toString();
            sDate       = formatter.parse(d1);
            eDate       = formatter.parse(d2);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        model.setDelegate(this);
    }

    /**
     * This method calls the createCoupon function in the model class.
     * Shows the user a success message.
     * */
    public void addCouponBtnClicked(View v) {
        model.createCoupon(cTitle, cCode, cValue, sDate, eDate);
        Toast.makeText(CreateCouponActivity.this, "Subscribers have been notified.",
                Toast.LENGTH_LONG).show();
    }

    /**
     * This method navigates the user to the RestaurantPageActivity.
     * */
    @Override
    public void goToRestPageActivity(){
        Intent myIntent = new Intent(CreateCouponActivity.this, RestaurantPageActivity.class);
        CreateCouponActivity.this.startActivity(myIntent);
        finish();
    }

}
