package com.example.menu_application;

public abstract class Vegetable extends CondimentDecorator {

    private static final String description = "";
    Sandwich sandwich;

    public Vegetable (Sandwich sandwich){
        super(description);
        this.sandwich = sandwich;
    }


    public String getDescription() {
        return description;
    }

    public abstract double cost();

    @Override
    public abstract String size();

}
