package com.betahax.recipease.model;

import java.util.ArrayList;

/**
 * Created by Owner on 9/20/2014.
 */
public class GroceryList {

    private int id;
    private ArrayList<Recipe> recipes;
    private String dateMade;

    public GroceryList(int id, ArrayList<Recipe> recipes, String dateMade) {
        this.id = id;
        this.recipes = recipes;
        this.dateMade = dateMade;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public String getDateMade() {
        return dateMade;
    }
}
