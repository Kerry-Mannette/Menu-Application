package com.example.menu_application;

public class Italian extends Bread{

    public  Italian (String d){ super(d);}

    @Override
    public String size() {
        return "";
    }

    public double cost() {
        return 0;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+"|  Italian  |";
    }
}
