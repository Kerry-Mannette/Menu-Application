package com.example.menu_application;

public class Wheat extends Bread{

    public  Wheat (String d){ super(d);}

    @Override
    public String size() {
        return "";
    }

    public double cost() {
        return 0;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+"|  Wheat  |";
    }
}
