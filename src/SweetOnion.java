package com.example.menu_application;

public class SweetOnion extends Sauces{

    public  SweetOnion (Sandwich s){ super(s);}

    @Override
    public String size() {
        return "";
    }


    @Override
    public String getDescription() {
        return " Sweet Onion  |";
    }
}
