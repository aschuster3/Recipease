package com.betahax.recipease;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.betahax.recipease.fragments.RecipeBookListFragment;


public class RecipeBook extends Activity implements
        RecipeBookListFragment.OnRecipeSelectionListener{

    Boolean displayRecipesAsGrid;
    MenuItem menuItem;
    Menu myMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displayRecipesAsGrid = false;
        setContentView(R.layout.activity_home);
        Fragment recipeFragment = RecipeBookListFragment.newInstance();
        getFragmentManager().beginTransaction().replace(R.id.container, recipeFragment).addToBackStack(null).commit();
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recipe_book, menu);

        menuItem = menu.findItem(R.id.RecipeListViewStyle);
        myMenu = menu;
        menuItem.getActionView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);

            }
        });

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        if (id == R.id.RecipeListViewStyle) {
            displayRecipesAsGrid ^= true;
            if (displayRecipesAsGrid == true) {
                setContentView(R.layout.fragment_recipe_book_grid);
                menuItem.setTitle("Grid");
                myMenu.clear();
                onCreateOptionsMenu(myMenu);
                Toast toast = Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT);
                toast.show();

            }else {
                setContentView(R.layout.fragment_recipe_book_list);
                menuItem.setTitle("List");
                myMenu.clear();
                onCreateOptionsMenu(myMenu);
                Toast toast = Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT);
                toast.show();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnRecipeSelected() {
        Intent myIntent = new Intent(this, InfoActivity.class);
        startActivity(myIntent);
    }
}
