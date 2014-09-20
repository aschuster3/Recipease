package com.betahax.recipease.model;

import java.util.ArrayList;

/**
 * Created by Owner on 9/20/2014.
 */
public class Recipe {

    public static final int BREAKFAST = 0,
                            LUNCH = 1,
                            DINNER = 2,
                            SNACK = 3;

    private int id;
    private ArrayList<String> ingredients;
    private ArrayList<String> directions;
    private int cookTime;
    private int base;
    private int serves;
    private String lastTimeCooked;
    private String imageSrc;
    private int mealTime;
    private String notes;

    public Recipe(int id, ArrayList<String> ingredients, ArrayList<String> directions,
                  int cookTime, int base, int serves, String lastTimeCooked,
                  String imageSrc, int mealTime, String notes) {
        this.id = id;
        this.ingredients = ingredients;
        this.directions = directions;
        this.cookTime = cookTime;
        this.base = base;
        this.serves = serves;
        this.lastTimeCooked = lastTimeCooked;
        this.imageSrc = imageSrc;
        this.mealTime = mealTime;
        this.notes = notes;
    }


    public int getId() {
        return id;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public ArrayList<String> getDirections() {
        return directions;
    }

    public int getCookTime() {
        return cookTime;
    }

    public int getBase() {
        return base;
    }

    public int getServes() {
        return serves;
    }

    public String getLastTimeCooked() {
        return lastTimeCooked;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public int getMealTime() {
        return mealTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

