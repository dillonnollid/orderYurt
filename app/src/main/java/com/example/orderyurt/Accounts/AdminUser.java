package com.example.orderyurt.Accounts;

public class AdminUser implements User {
    private int adminId;
    private String adminName;
    private String adminEmail;

    public AdminUser(String aName, String aEmail){
        this.adminName = aName;
        this.adminEmail = aEmail;
    }

    public void setName(String name){
        this.adminName = name;
    }

    @Override
    public String getName() {
        return adminName;
    }

    public void setEmail(String email){
        this.adminEmail = email;
    }

    @Override
    public String getEmail() {
        return adminEmail;
    }

    @Override
    public void setID(int ID) {
        adminId = ID;
    }

    @Override
    public int getID() {
        return adminId;
    }

}
