package com.example.menu_application;

public class Tomatoes extends Vegetable{

    public Tomatoes  (Sandwich s){ super(s);}

    @Override
    public String size() {
        return "";
    }

    @Override
    public double cost() {
        return 0;
    }

    @Override
    public String getDescription() {
        return " Tomatoes  |";
    }
}
