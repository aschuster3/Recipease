package com.betahax.recipease.api;

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
 * Created by ksudu94 on 9/21/2014.
 */
public class Globals {

    public   ArrayList<Recipe> performGET(String strURL,  ArrayList<Recipe> recipeArray){
        String responseString = "";
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(new HttpGet(strURL));
            StatusLine statusLine = response.getStatusLine();
            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                out.close();
                responseString = out.toString();
                //..more logic

            } else {
                //Closes the connection.
                response.getEntity().getContent().close();
            }
        } catch (IOException ie) {

        }

        try {
            //Recipe object
            JSONObject jsonObj = new JSONObject(responseString);
            //Recipes JSONArray
            JSONArray jsonRecipesArray = jsonObj.getJSONArray("matches");

            for (int i = 0; i < jsonRecipesArray.length(); i ++) {
                Recipe recipe = new Recipe();
                JSONObject childJSONObject = (JSONObject) jsonRecipesArray.get(i);
                recipe.setID(childJSONObject.getString("id"));
                recipe.setImgSrc(childJSONObject.getString("imageUrlsBySize"));
                recipe.setname(childJSONObject.getString("sourceDisplayName"));
                recipe.setRecipeURL(childJSONObject.getString("smallImageUrls"));
                recipe.setIngredients(jsonArrayToStringArray(childJSONObject.getString("ingredients")));

                recipeArray.add(i, recipe);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return recipeArray;
    }
    private ArrayList<String> jsonArrayToStringArray(String rawJSON) {
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

    public String buildURL(String strMealTime, String strBase, String strFlavor, String strMaxCookTime,
                            String appID, String appKey, int positionOfRecipe) {
        String strURL = "http://api.yummly.com/v1/api/recipes?_app_id=" + appID + "&_app_key=" + appKey + "&q=" + strBase +
                "&maxTotalTimeInSeconds=" + strMaxCookTime + "&flavor." + strFlavor + ".min=0.8&maxResult=20&start="+positionOfRecipe;
        positionOfRecipe  += 20;


        return strURL;

    }
}
