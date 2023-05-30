package com.example.caloriecheck;


public class Ingredient {
    private String name;
    private double amount;
    private String unit;
    private double calories;

    public Ingredient(String name, double amount, String unit, double calories) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    public double getCalories() {
        return calories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }




}
