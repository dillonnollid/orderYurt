package com.example.orderyurt.Pay;

public interface Pay {
    boolean verifyCard(float cardNum, int csv);
    boolean verifyPayment(int amount);
    String getPaymentInfo();

}
