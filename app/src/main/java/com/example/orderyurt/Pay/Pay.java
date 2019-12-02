package com.example.orderyurt.Pay;

public interface Pay {
    boolean verifyCard(String cardNum, String cvv);
    boolean isCardValid();
    boolean verifyPayment(int amount);
    String getPaymentInfo();
    void setPaymentInfo(String cardNum, String cvv);
    boolean result=false;

}
