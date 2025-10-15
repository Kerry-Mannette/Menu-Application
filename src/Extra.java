package com.example.menu_application;

public abstract class Extra extends CondimentDecorator {

    private static final String description = "";
    Sandwich sandwich;

    public Extra (Sandwich sandwich){
        super(description);
        this.sandwich = sandwich;
    }

    public abstract double cost();
    public abstract String size();
}
