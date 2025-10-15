package com.example.menu_application;

public class ParmesanOrgeano extends Bread{

    Bread bread;

    public  ParmesanOrgeano (String d){ super(d);}

    @Override
    public String size() {
        return "";
    }

    public double cost() {
        double cost;

        if(bread.getDescription().equals("Foot Long ")){
            cost = 2.00;
        }else {
            cost = 1.00;
        }

        return cost;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+"|  Parmesan Orgeano  |";
    }
}
