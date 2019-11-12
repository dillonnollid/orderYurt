package com.example.orderyurt.Pay;

public class ConventionalPay implements Payment {
    @Override
    public boolean verifyCard(float cardNum, int csv) {
        return false;
    }

    @Override
    public boolean verifyPayment(int amount) {
        return false;
    }
}
