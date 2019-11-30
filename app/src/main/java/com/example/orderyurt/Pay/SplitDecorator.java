package com.example.orderyurt.Pay;

class SplitDecorator extends PayDecorator {
    public SplitDecorator(Pay pay){
        super(pay);
    }

    @Override
    public boolean verifyCard(float cardNum, int csv) {
        return false;
    }

    @Override
    public boolean verifyPayment(int amount) {
        return false;
    }

    public String getPaymentInfo(){
        return super.getPaymentInfo() + "\n- Paying Split";
    }
}
