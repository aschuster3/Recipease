package com.betahax.recipease;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
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

import com.betahax.recipease.fragments.HomeFragment;
import com.betahax.recipease.fragments.RecipeBookListFragment;
import com.betahax.recipease.fragments.SelectorFragment;
import com.betahax.recipease.model.Recipe;


public class HomeActivity extends Activity implements
        HomeFragment.OnHomeFragmentInteractionListener,
        SelectorFragment.OnSelectorInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Fragment homeFragment = HomeFragment.newInstance();
        getFragmentManager().beginTransaction().replace(R.id.container, homeFragment).addToBackStack("Lol").commit();
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
        Intent myIntent = new Intent(this, Selector.class);
        startActivity(myIntent);
    }

    @Override
    public void OnSearchInteraction() {
        Intent myIntent = new Intent(this, QuestionTree.class);
        startActivity(myIntent);

    }

    @Override
    public void populate(WebView image, TextView text) {

    }

    @Override
    public void swipedLeft() {

    }

    @Override
    public void swipedRight(Recipe recipe, WebView image) {

    }
}
