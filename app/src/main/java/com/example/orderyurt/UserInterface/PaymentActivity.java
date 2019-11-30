package com.example.orderyurt.UserInterface;

import android.os.Bundle;

import com.example.orderyurt.Pay.BasePay;
import com.example.orderyurt.Pay.Pay;
import com.example.orderyurt.Pay.SoloDecorator;
import com.example.orderyurt.Pay.SplitDecorator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//import com.example.orderyurt.R;

public class PaymentActivity extends AppCompatActivity {
    private String cardNum, cvvNum, choice;
    View c1,c2;// = (EditText)findViewById(R.id.cardField),c2 =(EditText)findViewById(R.id.cvvField) ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
        //Toast.makeText(this, "TOASTY TOAST", Toast.LENGTH_LONG);

        if(choice=="solo"){
            Pay soloPay = new SoloDecorator(new BasePay());

            boolean chance = soloPay.verifyPayment(40);
            //chance = soloPay.verifyCard(cardNum, cvvNum);
            Toast.makeText(this, ("RESULT IS :") + chance, Toast.LENGTH_LONG).show();
            /*if(soloPay.verifyCard(cardNum, cvvNum)){
                if(soloPay.verifyPayment(15)){
                    Toast.makeText(this, "SUCCESSFUL PAYMENT", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(this, "COULD NOT VERIFY PAYMENT", Toast.LENGTH_LONG).show();
                }
            }
            else {
                Toast.makeText(this, "COULD NOT VERIFY CARD", Toast.LENGTH_LONG).show();
            }*/
        }
        else if(choice=="split"){
            Pay splitPay = new SplitDecorator(new BasePay());
            Toast.makeText(this, "CREATED SPLITPAY", Toast.LENGTH_LONG).show();
        }
    }
}
