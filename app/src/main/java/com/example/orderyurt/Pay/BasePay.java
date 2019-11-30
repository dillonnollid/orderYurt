package com.example.orderyurt.Pay;

public class BasePay implements Pay {
    private String cardNum, cvvNum, res="";
    private boolean valid=false;
    @Override
    public boolean verifyCard(String cardNum, String cvv) {
        if(cardNum.length() > 16){
            //Toast.MakeText((this.Activity), Resource.String.sent, ToastLength.Long).Show();
            //Toast.makeText((this.Activity), "INVALID CARD NUMBER: OVER 16 DIGITS", Toast.LENGTH_LONG).show();
            res+= "CARD NUMBER IS OVER 16 DIGITS IN LENGTH\n";

        } else if(cardNum.length() < 16){
            //Toast.makeText(this, "INVALID CARD NUMBER: UNDER 16 DIGITS", Toast.LENGTH_LONG).show();
            res+= "CARD NUMBER IS UNDER 16 DIGITS IN LENGTH\n";
        } else {
            if(cvvNum.length() > 3){
                res+= "CVV NUMBER IS OVER 3 DIGITS IN LENGTH\n";
                //Toast.makeText(this, "INVALID CVV NUMBER: OVER 3 DIGITS", Toast.LENGTH_LONG).show();
            } else if(cvvNum.length() < 3){
                res+= "CVV NUMBER IS UNDER 3 DIGITS IN LENGTH\n";
                //Toast.makeText(this, "INVALID CVV NUMBER: UNDER 3 DIGITS", Toast.LENGTH_LONG).show();
            } else {
                //only return true if cardNum = 16 and cvv =
                res+="Everything looks good with the cardnumber and cvv\n";
                this.cardNum = cardNum;
                this.cvvNum = cvvNum;
                valid=true;
                return true;
            }

        }

        return false;
    }

    @Override
    public boolean isCardValid() {
        return valid;
    }

    @Override
    public boolean verifyPayment(int amount) {
        if(amount > 20) return true;
        else return false;
    }

    @Override
    public String getPaymentInfo() {
        return null;
    }

    @Override
    public void setPaymentInfo(String cardNum, String cvv) {
        this.cardNum = cardNum;
        this.cvvNum = cvv;
    }

}
