package com.example.menu_application;

public class Tuna extends Sandwich{


    public  Tuna (Bread b){ super(b);}

    @Override
    public double cost() {
        return 5.00 + bread.getCost();
    }

    @Override
    public String size() {
        return "";
    }

    @Override
    public String getDescription() {
        return bread.getDescription()+" Tuna  |";
    }
}
