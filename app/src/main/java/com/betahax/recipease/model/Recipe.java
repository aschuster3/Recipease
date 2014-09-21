package com.betahax.recipease.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Owner on 9/20/2014.
 */
public class Recipe  implements Serializable {

    private String id;
    private String name;
    private ArrayList<String> ingredients;
    private String imageSrc;
    private String notes;
    private String recipeURL;

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setID(String id) {
        this.id = id;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setImgSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setRecipeURL(String recipeURL) {
        this.recipeURL = recipeURL;
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

    public String getRecipeURL() {
        return recipeURL;
    }

    public Recipe() {}
    public Recipe(String id, String name, ArrayList<String> ingredients, String imageSrc, String notes,
                  String recipeURL) {

        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.imageSrc = imageSrc;
        this.notes = notes;
        this.recipeURL = recipeURL;
    }
}

