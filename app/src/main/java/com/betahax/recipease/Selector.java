package com.betahax.recipease;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;


public class Selector extends Activity {

    final static String appID = "02d4c5e9";
    final static String appKey = "dbed5bd0b04bf806e7ef81f440640548";
    String URL;
    int cookTime, base, mealTime, flavor, positionOfRecipe;
    String strBase, strMealTime, strFlavor, strMaxCookTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cookTime = getIntent().getIntExtra("cooktime", 0);
        base = getIntent().getIntExtra("base", 0);
        mealTime = getIntent().getIntExtra("mealtime", 0);
        flavor = getIntent().getIntExtra("flavor", 0);
        positionOfRecipe = 20;

        formStrings(cookTime, base, mealTime, flavor);

        URL = buildURL(strMealTime, strBase, strFlavor, strMaxCookTime, appID, appKey, positionOfRecipe);

        PerformGetASYNC get = new PerformGetASYNC();
        get.execute();

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.selector, menu);
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

    public String buildURL(String strMealTime, String strBase, String strFlavor, String strMaxCookTime,
                           String appID, String appKey, int positionOfRecipe) {
        String strURL = "http://api.yummly.com/v1/api/recipes?_app_id=" + appID + "&_app_key=" + appKey + "&q=" + strBase +
                "&maxTotalTimeInSeconds=" + strMaxCookTime + "&flavor." + strFlavor + ".min=0.8&allowedCourse[]=course^course-" +
                strMealTime + "&maxResult=20&start="+positionOfRecipe;
        this.positionOfRecipe  += 20;


        return strURL;


    }
    public void formStrings (int cookTime, int base, int mealTime, int flavor) {


         switch (cookTime) {
            case 0:
                //30 mins
                strMaxCookTime = "1800";
                break;
            case 1:
                //2 hours
                strMaxCookTime = "7200";
                break;
            case 2:
                //10 hours
                strMaxCookTime = "36000";
                break;
             default:
                 //1 hours
                 strMaxCookTime = "3600";
                 break;
        }

        switch (base) {
            case 0:
                strBase = "Beef";
                break;
            case 1:
                strBase = "Chicken";
                break;
            case 2:
                strBase = "Fish";
                break;
            case 3:
                strBase = "Pork";
                break;
            case 4:
                strBase = "Tofu";
                break;
            case 5:
                strBase = "Vegan";
                break;
            case 6:
                strBase = "Vegetarian";
                break;
            default:
                strMealTime = "Beef";
                break;
        }

        switch (mealTime) {
            case 0:
                strMealTime = "Breakfast and Brunch";
                break;
            case 1:
                strMealTime = "Lunch and Snacks";
                break;
            case 2:
                strMealTime = "Main Dishes";
                break;
            case 3:
                strMealTime = "Appetizer";
                break;
            case 4:
                strMealTime = "Desserts";
                break;
            default:
                strMealTime = "Dinner";
                break;
        }

        switch (flavor) {
            case 0:
                strFlavor = "bitter";
                break;
            case 1:
                strFlavor = "sweet";
                break;
            case 2:
                strFlavor = "salty";
                break;
            case 3:
                strFlavor = "sour";
                break;
            case 4:
                strFlavor = "meaty";
                break;
            case 6:
                strFlavor = "piquant";
                break;
            default:
                strFlavor = "meaty";
                break;

        }


    }

    public class PerformGetASYNC extends AsyncTask<Void, Void, String> {

        protected void onPostExecute(String response) {

            Toast toast = Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG);
            toast.show();
        }

        @Override
        protected String doInBackground(Void... voids) {
             return performGET();

        }
    }
    public String performGET(){
        String responseString = "";
       try {
           HttpClient httpclient = new DefaultHttpClient();
           HttpResponse response = httpclient.execute(new HttpGet(URL));
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
            JSONArray recipesArray = jsonObj.getJSONArray("Boobs");
            for (int i = 0; i < recipesArray.length(); i ++) {
                JSONObject c = recipesArray.getJSONObject(i);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return responseString;
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_selector, container, false);
            return rootView;
        }
    }
}
