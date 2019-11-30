package com.example.orderyurt.Pay;

public abstract class PayDecorator implements Pay {
    private final BasePay decoratedPay;


    public PayDecorator(BasePay pay) {
        this.decoratedPay = pay;
    }

    public String getPaymentInfo(){
        return decoratedPay.getPaymentInfo();
    }

    public void setPaymentInfo(String cardNum, String cvv){
        decoratedPay.setPaymentInfo(cardNum, cvv);
    }
    public boolean verifyCard(String cardNum, String cvv){
        return decoratedPay.verifyCard(cardNum, cvv);
    }
    public boolean verifyPayment(int amount){
        return decoratedPay.verifyPayment(amount);
    }
    public boolean isCardValid(){
        return decoratedPay.isCardValid();
    }
}
