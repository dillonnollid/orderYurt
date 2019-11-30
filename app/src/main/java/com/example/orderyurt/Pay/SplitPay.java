package com.example.orderyurt.Pay;

public class SplitPay implements Pay {


    @Override
    public boolean verifyCard(String cardNum, String cvv) {
        return false;
    }

    @Override
    public boolean isCardValid() {
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

    @Override
    public void setPaymentInfo(String cardNum, String cvv) {

    }
}
