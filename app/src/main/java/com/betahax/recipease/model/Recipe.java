package com.betahax.recipease.model;

import java.util.ArrayList;

/**
 * Created by Owner on 9/20/2014.
 */
public class Recipe {

    private String id;
    private String name;
    private ArrayList<String> ingredients;
    private String imageSrc;
    private String notes;

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public String getNotes() {
        return notes;
    }

    public Recipe(String id, String name, ArrayList<String> ingredients, String imageSrc, String notes) {

        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.imageSrc = imageSrc;
        this.notes = notes;
    }
}

