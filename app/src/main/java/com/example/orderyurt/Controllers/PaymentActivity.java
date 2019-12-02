package com.example.orderyurt.Controllers;

import android.content.Intent;
import android.os.Bundle;

import com.example.orderyurt.Pay.BasePay;
import com.example.orderyurt.Pay.Pay;
import com.example.orderyurt.Pay.SoloDecorator;
import com.example.orderyurt.Pay.SplitDecorator;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//TODO: ADD MVC!!

/**
 * PaymentActivity class creates Payment Menu and
 */
public class PaymentActivity extends AppCompatActivity {
    private String cardNum, cvvNum, choice, rest, contents;
    private Double totalprice;
    View c1,c2;// = (EditText)findViewById(R.id.cardField),c2 =(EditText)findViewById(R.id.cvvField) ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        rest = b.getString("restName");
        contents = b.getString("contents");
        totalprice = b.getDouble("totalprice");

        c1 = (EditText)findViewById(R.id.cardField);
        c2 =(EditText)findViewById(R.id.cvvField);

        c1.setVisibility(View.GONE);
        c2.setVisibility(View.GONE);

    }

    public void soloClick(View view) {
        choice = "solo";
        View b = findViewById(R.id.splitButton);
        b.setVisibility(View.GONE);

        c1.setVisibility(View.VISIBLE);
        c2.setVisibility(View.VISIBLE);
    }

    public void splitClick(View view) {
        choice = "split";
        View b = findViewById(R.id.soloButton);
        b.setVisibility(View.GONE);

        c1.setVisibility(View.VISIBLE);
        c2.setVisibility(View.VISIBLE);
    }

    public void completeClicked(View view) {
        cardNum = ((EditText) findViewById(R.id.cardField)).getText().toString();
        cvvNum = ((EditText) findViewById(R.id.cvvField)).getText().toString();
        c1.setVisibility(View.GONE);
        c2.setVisibility(View.GONE);

        if(choice=="solo"){
            Pay soloPay = new SoloDecorator(new BasePay());

            if(soloPay.verifyCard(cardNum, cvvNum)){
                if(soloPay.verifyPayment(totalprice.intValue())){
                    Toast.makeText(this, "SUCCESSFUL PAYMENT", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this, "COULD NOT VERIFY PAYMENT", Toast.LENGTH_LONG).show();
                }
            }
            else {
                Toast.makeText(this, "COULD NOT VERIFY CARD", Toast.LENGTH_LONG).show();
            }
        }
        else if(choice=="split"){
            Pay splitPay = new SplitDecorator(new BasePay());
            Toast.makeText(this, "CREATED SPLITPAY", Toast.LENGTH_LONG).show();
        }
    }
}