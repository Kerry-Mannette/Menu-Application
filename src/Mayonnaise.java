package com.example.menu_application;

public class Mayonnaise extends Sauces{

    public  Mayonnaise (Sandwich s){ super(s);}

    @Override
    public String size() {
        return "";
    }


    @Override
    public String getDescription() {
        return " Mayonnaise  |";
    }
}
