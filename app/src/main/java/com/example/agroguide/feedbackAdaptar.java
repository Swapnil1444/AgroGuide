package com.example.agroguide;

public class feedbackAdaptar {
    public feedbackAdaptar(String name, String email, String feedbaek) {
        this.name = name;
        Email = email;
        this.feedbaek = feedbaek;
    }

    String name;
    String Email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFeedbaek() {
        return feedbaek;
    }

    public void setFeedbaek(String feedbaek) {
        this.feedbaek = feedbaek;
    }

    String feedbaek;
}
