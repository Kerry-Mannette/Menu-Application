package com.example.menu_application;

public class GarlicSauce extends Sauces{

    public GarlicSauce(Sandwich s){ super(s);}

    @Override
    public String size() {
        return "";
    }

    @Override
    public String getDescription() {
        return "Garlic Sauce  |";
    }
}
