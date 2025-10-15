package com.example.menu_application;

public class GreenBellPeppers extends Vegetable{

    public GreenBellPeppers  (Sandwich s){ super(s);}

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
        return " Green Bell Peppers  |";
    }

}
