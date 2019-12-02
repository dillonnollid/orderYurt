package com.example.orderyurt.Pay;

public class SoloDecorator extends PayDecorator {
    public SoloDecorator(BasePay pay){
        super(pay);
    }
    public String getPaymentInfo(){
        return super.getPaymentInfo() + "\n- Paying Solo";
    }
    @Override
    public boolean verifyCard(String cardNum, String csv) {
        return super.verifyCard(cardNum, csv);
    }
    @Override
    public boolean verifyPayment(int amount) {
        return super.verifyPayment(amount);
    }
    @Override
    public void setPaymentInfo(String cardNum, String cvv) {
        super.setPaymentInfo(cardNum, cvv);
    }
}
