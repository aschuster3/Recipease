package com.betahax.recipease.api;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.betahax.recipease.database.RecipeDBHelper;
import com.betahax.recipease.database.contracts.RecipeContract;
import com.betahax.recipease.model.Recipe;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Owner on 9/20/2014.
 */
public class DatabaseReader {

    public static ArrayList<Recipe> fetchSavedRecipes(Context context) {
        ArrayList<Recipe> recipes = new ArrayList<Recipe>();
        SQLiteDatabase db = new RecipeDBHelper(context).getReadableDatabase();

        Cursor c = db.rawQuery(RecipeContract.FETCH_RECIPES, null);

        c.moveToFirst();

        int colId = c.getColumnIndex(RecipeContract.DBEntry._ID),
            colRecipeName = c.getColumnIndex(RecipeContract.DBEntry.RECIPE_NAME),
            colIngredients = c.getColumnIndex(RecipeContract.DBEntry.INGREDIENTS),
            colImageSrc = c.getColumnIndex(RecipeContract.DBEntry.IMAGE_SOURCE),
            colRecipeDirections = c.getColumnIndex(RecipeContract.DBEntry.RECIPE_DIRECTIONS),
            colNotes = c.getColumnIndex(RecipeContract.DBEntry.NOTES);

        int size = c.getCount();
        Recipe r;
        for(int i = 0; i < size; i++) {
            r = new Recipe(c.getString(colId), c.getString(colRecipeName), jsonArrayToStringArray(c.getString(colIngredients)),
                    c.getString(colImageSrc), c.getString(colNotes), c.getString(colRecipeDirections));

            recipes.add(r);
        }
        return recipes;
    }

    private static ArrayList<String> jsonArrayToStringArray(String rawJSON) {
        ArrayList<String> ingredients = new ArrayList<String>();

        try {
            JSONArray arr = new JSONArray(rawJSON);

            for(int i = 0; i < arr.length(); i++) {
                ingredients.add(arr.getString(i));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return ingredients;
    }

    public static void saveRecipe(Context context, String recipeName, String ingredients, String imageSrc) {
        SQLiteDatabase db = new RecipeDBHelper(context).getWritableDatabase();

        // TODO query api for recipe information and other jazzy information

        //db.rawQuery(RecipeContract.putRecipe())
    }
}
