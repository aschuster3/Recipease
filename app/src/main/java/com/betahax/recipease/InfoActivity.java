package com.betahax.recipease;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.betahax.recipease.fragments.BackgroundImage;
import com.betahax.recipease.fragments.ForegroundDescription;


public class InfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String strName = getIntent().getStringExtra("recipeName");
        String strImageSource = getIntent().getStringExtra("imageSrc");
        // TODO For BackgroundImage, you need a valid URL
        // TODO For ForgroundDescription, you need 1) the name of the recipe, 2) a JSONArray of Strings for the ingredients, and 3) the directions to make it.

        getFragmentManager().beginTransaction()
                .add(R.id.container, BackgroundImage.newInstance(strImageSource))
                .add(R.id.container, ForegroundDescription.newInstance(strName, "[\"cats\"]", "s;adlkjf;sad jlkdsjf lksadjf sd;jf as;lkdfj as;kdjf\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n as;dkfj asd;lkfj sad;fkljsa dfk;ljds f;sakfj ;askdfj as;kdjf ksa;djfkas;dj fsa;kdljf ask;ldjf a;lksdjf a;sdklfj ;sakdlfj sa;dkfjasd;klfjas ;lkdfjask flkdsajf lksadjf;lksdjflksjdaflk ;dsajf lsjdakf j;kl j;lkasjfd ;lkdsajf ;ksdjf ;askdjf "))
                .commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.info, menu);
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
}
