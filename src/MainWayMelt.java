package com.example.menu_application;

public class MainWayMelt extends Sandwich{

    public  MainWayMelt (Bread b){ super(b);}


    @Override
    public double cost() {
        return 2.00 + bread.getCost();
    }

    @Override
    public String size() {
        return "";
    }

    @Override
    public String getDescription() {
        return bread.getDescription()+" Mainway Melt  |";
    }
}
