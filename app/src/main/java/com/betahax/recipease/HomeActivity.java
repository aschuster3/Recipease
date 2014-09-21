package com.betahax.recipease;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.betahax.recipease.api.Globals;
import com.betahax.recipease.fragments.HomeFragment;
import com.betahax.recipease.fragments.RecipeBookListFragment;
import com.betahax.recipease.fragments.SelectorFragment;
import com.betahax.recipease.model.Recipe;

import java.util.ArrayList;


public class HomeActivity extends Activity implements
        HomeFragment.OnHomeFragmentInteractionListener,
        SelectorFragment.OnSelectorInteractionListener{

    Globals objGlobals;
    ArrayList<Recipe> emptyRecipeArray = new ArrayList<Recipe>();
    String URL = "http://api.yummly.com/v1/api/recipes?_app_id=02d4c5e9&_app_key=dbed5bd0b04bf806e7ef81f440640548";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Fragment homeFragment = HomeFragment.newInstance();
        getFragmentManager().beginTransaction().replace(R.id.container, homeFragment).addToBackStack("Lol").commit();

        objGlobals = new Globals();
    }
    // Hay

    //Hay back

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onTouchEvent(MotionEvent event){

        int action = event.getAction();

        switch(action) {

            case (MotionEvent.ACTION_DOWN) :
                Toast toast = Toast.makeText(this, "Down", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case (MotionEvent.ACTION_MOVE) :
                toast = Toast.makeText(this, "Move", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case (MotionEvent.ACTION_UP) :
                toast = Toast.makeText(this, "Up", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case (MotionEvent.ACTION_CANCEL) :
                toast = Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case (MotionEvent.ACTION_OUTSIDE) :
                toast = Toast.makeText(this, "??", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            default :
                return super.onTouchEvent(event);
        }
    }


    @Override
    public void OnRecipeBookInteraction() {
        Intent myIntent = new Intent(this, RecipeBook.class);

        startActivity(myIntent);

    }

    @Override
    public void OnRandomInteraction() {

        PerformGetEmptyASYNC get = new PerformGetEmptyASYNC();
        get.execute();


    }

    @Override
    public void OnSearchInteraction() {
        Intent myIntent = new Intent(this, QuestionTree.class);
        startActivity(myIntent);

    }

    @Override
    public void populate(WebView view, TextView recipe_name, ArrayList<Recipe> recipeInputArray, int count) {
        if(count < recipeInputArray.size()){
            String url = recipeInputArray.get(count).getImageSrc().substring(7, recipeInputArray.get(count).getImageSrc().length()-2);
            view.loadUrl(url);
            recipe_name.setText(recipeInputArray.get(count).getName());
        } else {
            //Reset to #1
            String url = recipeInputArray.get(0).getImageSrc().substring(7, recipeInputArray.get(0).getImageSrc().length()-2);
            view.loadUrl(url);
            recipe_name.setText(recipeInputArray.get(0).getName());
            count = 0;
        }
    }

    @Override
    public void swipedLeft() {

    }

    @Override
    public void swipedRight(Recipe recipe, WebView image) {

    }

    class PerformGetEmptyASYNC extends AsyncTask<Void, Void,   ArrayList<Recipe> > {

        protected void onPostExecute( ArrayList<Recipe> result) {

            Fragment selectorFragment = SelectorFragment.newInstance(emptyRecipeArray);
            getFragmentManager().beginTransaction().replace(R.id.container, selectorFragment).addToBackStack(null).commit();

        }

        @Override
        protected   ArrayList<Recipe> doInBackground(Void... voids) {
            return objGlobals.performGET(URL, emptyRecipeArray);

        }
    }
}
