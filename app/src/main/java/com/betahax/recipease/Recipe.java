package com.betahax.recipease;

import java.util.ArrayList;

/**
 * Created by ksudu94 on 9/20/2014.
 */
public class Recipe {

    public int RID, cookTime, base, servingSize, numberTimesPrepared, mealTime;
    public long lastTimePrepared;
    public String imageSourceURL, notes;
    public ArrayList<String> directions, ingredients;
    public Recipe() {}

}
