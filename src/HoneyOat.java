package com.example.menu_application;

public class HoneyOat extends Bread{

    Bread bread;

    public  HoneyOat (String d){ super(d);}

    @Override
    public String size() {
        return "";
    }

    public double cost() {
        double cost;

        if(super.getDescription().equals("Foot Long ")){
            cost = 2.00;
        }else {
            cost = 1.00;
        }

        return cost;
    }


    @Override
    public String getDescription() {
        return super.getDescription()+"|  Honey Oat  |";
    }
}
