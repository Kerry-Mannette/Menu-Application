package com.example.menu_application;

public abstract class CondimentDecorator extends Bread{
    public CondimentDecorator(String description) {
        super(description);
    }

    public abstract String getDescription();
}
