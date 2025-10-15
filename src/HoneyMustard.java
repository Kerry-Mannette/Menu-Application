package com.example.menu_application;

public class HoneyMustard extends Sauces{

    public  HoneyMustard (Sandwich s){ super(s);}

    @Override
    public String size() {
        return "";
    }

    @Override
    public String getDescription() {
        return " Honey Mustard  |";
    }
}
