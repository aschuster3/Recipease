package com.betahax.recipease.api;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.betahax.recipease.database.RecipeDBHelper;
import com.betahax.recipease.database.contracts.RecipeContract;
import com.betahax.recipease.model.Recipe;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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

    public static final String URL = "http://api.yummly.com/v1/api/recipe/",
                               URL_END = "?_app_id=02d4c5e9&_app_key=dbed5bd0b04bf806e7ef81f440640548";

    public static void saveRecipe(Context context, String id, String recipeName, String ingredients, String imageSrc) {
        SQLiteDatabase db = new RecipeDBHelper(context).getWritableDatabase();

        // TODO query api for recipe information and other jazzy information
        String responseString, sourceUrl;
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(new HttpGet(URL + id + URL_END));
            StatusLine statusLine = response.getStatusLine();
            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                out.close();
                responseString = out.toString();

                JSONObject obj = new JSONObject(responseString);
                sourceUrl = obj.getJSONObject("source").getString("sourceRecipeUrl");

                db.execSQL(RecipeContract.putRecipe(id, recipeName, ingredients, imageSrc, sourceUrl));
            } else {
                //Closes the connection.
                response.getEntity().getContent().close();
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }
}
