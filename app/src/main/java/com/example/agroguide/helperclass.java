package com.example.agroguide;

public class helperclass {
    String name;
    String email;
    String username;

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    String Number;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String password;

    public helperclass(String name, String email, String username, String password ,String Number) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.Number=Number;

    }

    public helperclass() {
    }
}
