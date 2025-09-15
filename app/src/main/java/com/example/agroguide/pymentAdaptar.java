package com.example.agroguide;

public class pymentAdaptar {

    String name;
    String city;
    String state;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getMm_yy() {
        return mm_yy;
    }

    public void setMm_yy(String mm_yy) {
        this.mm_yy = mm_yy;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    String pincode;
    String card_number;
    String mm_yy;
    String cvv;
    String email;

    String Number;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    String price;

    public String getProdect_name() {
        return prodect_name;
    }

    public void setProdect_name(String prodect_name) {
        this.prodect_name = prodect_name;
    }

    String prodect_name;


    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public pymentAdaptar(String name, String email ,String Number, String city,String state,String pincode,String card_number,String mm_yy,String cvv,String prodect_name,String price) {
        this.name = name;
        this.email = email;
        this.Number=Number;
        this.city=city;
        this.state=state;
        this.pincode=pincode;
        this.card_number=card_number;
        this.mm_yy=mm_yy;
        this.cvv=cvv;
        this.prodect_name=prodect_name;
        this.price=price;

    }

}
