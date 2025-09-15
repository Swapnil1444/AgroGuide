package com.example.agroguide;


import java.util.ArrayList;

class vegetable {
    private ArrayList <vegetable> vegetables;

    public vegetable (String tomato, String pune, String date, String s) {
        vegetables = new ArrayList<> ();
    }

    public vegetable get(int position) {
        return vegetables.get(position);
    }

    public int size() {
        return vegetables.size();
    }

    public void add(vegetable vegetable) {
        vegetables.add(vegetable);
    }

    public int getName() {
        return 0;
    }

    public int getCity() {
        return 0;
    }

    public int getDate() {
        return 0;
    }

    public int getPrice() {
        return 0;
    }
}
