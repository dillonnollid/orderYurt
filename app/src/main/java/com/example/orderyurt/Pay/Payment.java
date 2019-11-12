package com.example.orderyurt.Pay;

public interface Payment {
    public boolean verifyCard(float cardNum, int csv);

    public boolean verifyPayment(int amount);
}
