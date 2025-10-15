package com.example.menu_application;

public abstract class Sauces extends CondimentDecorator{

    private static final String description = "";
    Sandwich sandwich;

    public Sauces (Sandwich sandwich){
        super(description);
        this.sandwich = sandwich;
    }

}

