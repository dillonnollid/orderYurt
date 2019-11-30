package com.example.orderyurt.UserInterface;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.orderyurt.Accounts.RestaurantUser;
import com.example.orderyurt.Discount.Coupon;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateCouponActivity extends AppCompatActivity {
    //Create coupon object and add it to db for this restaurant
    private RestaurantUser rUser = new RestaurantUser();
    private Coupon newCoupon;
    private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private Date eDate, sDate;
    private Double  cValue = 0.0;
    private String cCode, cTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_coupon);

        //Grabbing the input from the EditText boxes
        EditText title, code, value, startDate, endDate;
        Button addCouponBtn = (Button) findViewById(R.id.addCouponBtn);

        title = (EditText) findViewById(R.id.title);
        code = (EditText) findViewById(R.id.code);
        value = findViewById(R.id.value);
        startDate = findViewById(R.id.startDate);
        endDate = findViewById(R.id.endDate);

        //Assigning the input to variables of the correct type
        cTitle = title.getText().toString();
        cCode = code.getText().toString();
        String v = value.getText().toString();
        if (!v.isEmpty()) {
            try {
                cValue = Double.parseDouble(v);
                // it means it is double
            } catch (Exception e1) {
                // this means it is not double
                e1.printStackTrace();
            }
        }
        //Try catch is for formatting the dates.
        try {
            String d1 = startDate.getText().toString();
            String d2 = endDate.getText().toString();
            sDate = formatter.parse(d1);
            eDate = formatter.parse(d2);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            Log.i("Caught:", e.toString());
        }

        //Calling coupon constructor. Need to assign the RID correctly.
        addCouponBtn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        newCoupon = new Coupon(cTitle, cCode, cValue, sDate, eDate, 1);
                        rUser.notifySubscribers(newCoupon);

                        Toast.makeText(CreateCouponActivity.this, R.string.coupon_added,
                                Toast.LENGTH_LONG).show();

                        Intent myIntent = new Intent(CreateCouponActivity.this, RestaurantPageActivity.class);
                        CreateCouponActivity.this.startActivity(myIntent);
                    }
                });
    }
}
