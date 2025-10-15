package com.example.menu_application;

public class BlackOlives extends Extra{

    public  BlackOlives (Sandwich s){ super(s);}

    @Override
    public double cost() {
        double cost;
        if(sandwich.getDescription().contains("Foot Long ")){
            cost = 2.00;
        }else {
            cost = 1.00;
        }
        return cost + sandwich.cost();
    }

    @Override
    public String size() {
        return "";
    }

    @Override
    public String getDescription() {
        return " Black Olives |";
    }
}
