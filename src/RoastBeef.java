package com.example.menu_application;

public class RoastBeef extends Sandwich{


    public  RoastBeef (Bread b){ super(b);}

    @Override
    public double cost() {
        return 7.00 + bread.getCost();
    }

    @Override
    public String size() {
        return "";
    }

    @Override
    public String getDescription() {
        return bread.getDescription()+" Roast Beef  |";
    }
}
