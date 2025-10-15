package com.example.menu_application;

public class ChickenTeriyaki extends Sandwich{


    public  ChickenTeriyaki (Bread b){ super(b);}

    @Override
    public double cost() {
        return  7.00 + bread.getCost();
    }

    @Override
    public String size() {
        return "";
    }

    @Override
    public String getDescription() {
        return bread.getDescription()+" Chicken Teriyaki  |";
    }
}
