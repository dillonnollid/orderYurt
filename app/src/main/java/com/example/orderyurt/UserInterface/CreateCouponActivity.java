package com.example.orderyurt.UserInterface;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.orderyurt.Discount.Coupon;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateCouponActivity extends AppCompatActivity {
    //Create coupon object and add it to db for this restaurant

    Coupon newCoupon;
    Button addCouponBtn;
    EditText title, code, value, startDate, endDate;
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date eDate, sDate;
    float  cValue;
    String cCode, cTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_coupon);

        //Grabbing the input from the EditText boxes
        addCouponBtn = findViewById(R.id.addCouponBtn);
        title = findViewById(R.id.title);
        code = findViewById(R.id.code);
        value = findViewById(R.id.value);
        startDate = findViewById(R.id.startDate);
        endDate = findViewById(R.id.endDate);

        //Assigning the input to variables of the correct type
        cTitle = title.getText().toString();
        cCode = code.getText().toString();
        cValue = Float.valueOf(value.getText().toString());

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
                    }
                });
    }
}
