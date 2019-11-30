package com.example.orderyurt.Pay;

public class SoloPay implements Pay {
    @Override
    public boolean verifyCard(float cardNum, int csv) {
        return false;
    }

    @Override
    public boolean verifyPayment(int amount) {
        return false;
    }

    @Override
    public String getPaymentInfo() {
        return null;
    }
}
