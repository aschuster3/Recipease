package com.betahax.recipease;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.betahax.recipease.fragments.RecipeBookListFragment;


public class HomeActivity extends Activity {

    private static final String DEBUG_TAG = "Gestures";
    Button btnSearchRecipes;
    Button btnMyRecipes;
    Button btnRandomRecipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        btnSearchRecipes = (Button) findViewById(R.id.btnSearchRecipes);
        btnRandomRecipes = (Button) findViewById(R.id.btnRandomRecipes);
        btnMyRecipes = (Button) findViewById(R.id.btnMyRecipes);

        btnMyRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent myIntent = new Intent("com.betahax.recipease.RecipeBook");
                //startActivity(myIntent);
                startActivity(new Intent(getApplicationContext(),RecipeBook.class));
            }
        });

        btnSearchRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, QuestionTree.class));
            }
        });

       /* btnSearchRecipes.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();

                switch(action) {

                    case (MotionEvent.ACTION_DOWN) :
                        Toast toast = Toast.makeText(getApplicationContext(), "Down", Toast.LENGTH_SHORT);
                        toast.show();
                        return true;
                    case (MotionEvent.ACTION_MOVE) :
                        toast = Toast.makeText(getApplicationContext(), "Move", Toast.LENGTH_SHORT);
                        toast.show();
                        return true;
                    case (MotionEvent.ACTION_UP) :
                        toast = Toast.makeText(getApplicationContext(), "Up", Toast.LENGTH_SHORT);
                        toast.show();
                        return true;
                    case (MotionEvent.ACTION_CANCEL) :
                        toast = Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_SHORT);
                        toast.show();
                        return true;
                    case (MotionEvent.ACTION_OUTSIDE) :
                        toast = Toast.makeText(getApplicationContext(), "??", Toast.LENGTH_SHORT);
                        toast.show();
                        return true;
                    default :
                        return false;
                }
            }
        });*/

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
}
