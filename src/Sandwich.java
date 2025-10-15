package com.example.menu_application;

public abstract class Sandwich extends Bread {

    private static final String description = "";
    Bread bread;


    public Sandwich (Bread bread){
        super(description);
        this.bread = bread;
    }

    public abstract double cost();
    public abstract String size();


}
