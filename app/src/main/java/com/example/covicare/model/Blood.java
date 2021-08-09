package com.example.covicare.model;

public class Blood {
    private int id;
    private String name,phonenumber,mail,city,street;

    public Blood(int id, String name, String phonenumber, String mail, String city, String street) {
        this.id = id;
        this.name = name;
        this.phonenumber = phonenumber;
        this.mail = mail;
        this.city = city;
        this.street = street;
    }

    public Blood(String name, String phonenumber, String mail, String city, String street) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.mail = mail;
        this.city = city;
        this.street = street;
    }

    public Blood(){}



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
