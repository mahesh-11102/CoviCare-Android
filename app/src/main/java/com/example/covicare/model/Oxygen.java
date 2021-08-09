package com.example.covicare.model;

public class Oxygen {
    private int id;
    private String dealer_name,phonenumber,mail,city,street;


    public Oxygen(int id, String dealer_name, String phonenumber, String mail, String city, String street) {
        this.id = id;
        this.dealer_name = dealer_name;
        this.phonenumber = phonenumber;
        this.mail = mail;
        this.city = city;
        this.street = street;
    }

    public Oxygen(String dealer_name, String phonenumber, String mail, String city, String street) {
        this.dealer_name = dealer_name;
        this.phonenumber = phonenumber;
        this.mail = mail;
        this.city = city;
        this.street = street;
    }

    public Oxygen(){}



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getdealer_name() {
        return dealer_name;
    }

    public void setdealer_name(String dealer_name) {
        this.dealer_name = dealer_name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
