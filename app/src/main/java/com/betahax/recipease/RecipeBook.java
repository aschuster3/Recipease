package com.betahax.recipease;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class RecipeBook extends Activity {

    Boolean displayRecipesAsGrid;
    MenuItem item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displayRecipesAsGrid = false;
        setContentView(R.layout.fragment_recipe_book_list);
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recipe_book, menu);

        item = menu.findItem(R.id.RecipeListViewStyle);
        item.getActionView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(item);
                //Toast toast = Toast.makeText(getApplicationContext(), "You clicked.!", Toast.LENGTH_SHORT);
                //toast.show();

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
        displayRecipesAsGrid ^= true;
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.RecipeListViewStyle) {
            if (displayRecipesAsGrid == true) {
                setContentView(R.layout.fragment_recipe_book_grid);
                item.setActionView(R.layout.grid);
                Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(id), Toast.LENGTH_SHORT);
                toast.show();
            }else {
                setContentView(R.layout.fragment_recipe_book_list);
                item.setActionView(R.layout.list);
            }
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.listView) {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
