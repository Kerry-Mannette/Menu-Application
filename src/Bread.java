package com.example.menu_application;

public abstract class Bread {

    private String description = "Unknown Bread";
    private double cost;

    public Bread(String description){
        this.description = description;
        if(description.equals("Foot Long ")){
            cost = 30.00;
        }else {
            cost = 20.00;
        }

    }

    public double getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public abstract String size();


}
