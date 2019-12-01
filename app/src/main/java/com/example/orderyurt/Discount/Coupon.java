package com.example.orderyurt.Discount;

import java.util.Date;

public class Coupon {
    private String title;
    private String code; //CouponID in DB
    private Double value;
    private Date startDate;
    private Date endDate;
    private int RID;

    public Coupon(String title, String code, Double value, Date startDate, Date endDate, int RID){
        this.title = title;
        this.code = code;
        this.value = value;
        this.startDate = startDate;
        this.endDate = endDate;
        this.RID = RID;
    }

    public Double getValue(){
        return this.value;
    }

    public String getCode(){
        return code;
    }

    public Date getStartDate(){
        return startDate;
    }

    public Date getEndDate(){
        return endDate;
    }
}
