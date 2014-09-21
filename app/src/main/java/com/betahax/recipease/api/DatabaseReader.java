package com.betahax.recipease.api;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.betahax.recipease.database.RecipeDBHelper;
import com.betahax.recipease.model.Recipe;

import java.util.ArrayList;

/**
 * Created by Owner on 9/20/2014.
 */
public class DatabaseReader {

    public static ArrayList<Recipe> fetchSavedRecipes(Context context) {
        SQLiteDatabase db = new RecipeDBHelper(context).getReadableDatabase();


        return null;
    }
}
