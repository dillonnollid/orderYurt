package com.example.orderyurt.Pay;

public abstract class PayDecorator implements Pay {
    private final Pay decoratedPay;


    public PayDecorator(Pay pay) {
        this.decoratedPay = pay;
    }

    public String getPaymentInfo(){
        return decoratedPay.getPaymentInfo();
    }
}
