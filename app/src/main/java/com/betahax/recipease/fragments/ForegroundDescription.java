package com.betahax.recipease.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.betahax.recipease.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class ForegroundDescription extends Fragment {

    private static final String RECIPE_NAME = "name";
    private static final String INGREDIENTS = "ingred";
    private static final String DIRECTIONS = "dir";

    // TODO: Rename and change types of parameters
    private String recipeName;
    private ArrayList<String> ingredients;
    private String directions;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param recipeName The name of the recipe.
     * @param ingredientsRaw A raw JSONArray of all the ingredients in a recipe.
     * @param directions The directions to prepare the recipe.
     *
     * @return A new instance of fragment ForegroundDescription.
     */
    // TODO: Rename and change types and number of parameters
    public static ForegroundDescription newInstance(String recipeName, String ingredientsRaw, String directions) {
        ForegroundDescription fragment = new ForegroundDescription();
        Bundle args = new Bundle();
        args.putString(RECIPE_NAME, recipeName);
        args.putString(INGREDIENTS, ingredientsRaw);
        args.putString(DIRECTIONS, directions);
        fragment.setArguments(args);
        return fragment;
    }
    public ForegroundDescription() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            recipeName = getArguments().getString(RECIPE_NAME);
            ingredients = jsonArrayToStringArray(getArguments().getString(INGREDIENTS));
            directions = getArguments().getString(DIRECTIONS);
        }
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_foreground_description, container, false);

        ((TextView) view.findViewById(R.id.recipe_name)).setText(recipeName);
        generateIngredientsView(((LinearLayout) view.findViewById(R.id.list_of_ingredients)), ingredients);
        ((TextView) view.findViewById(R.id.directions_body)).setText(directions);

        return view;
    }

    private void generateIngredientsView(LinearLayout layout, ArrayList<String> ingredients) {

        // TODO populate ingredients layout

    }
}
