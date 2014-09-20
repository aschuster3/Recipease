package com.betahax.recipease;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.betahax.recipease.fragments.QuestionTreeFragment;


public class QuestionTree extends Activity implements QuestionTreeFragment.OnQuestionTouchListener {

    //Length of time available to cook
    int cookTime;
    //Breakfast = 0, Lunch = 1, Dinner = 2, Snack = 3
    int mealTime;
    //Beef = 0, Chicken = 1, Pork = 2, Tofu = 3, Vegetarian = 4, Vegan = 5
    int base;
    //Check yummly,
    int flavor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_tree);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.question_tree, menu);
        return true;
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

        return super.onOptionsItemSelected(item);
    }



    /**
     * Receives all the parameters from the questions
     */
    @Override
    public void onQuestionTouch(int var) {

    }
}
