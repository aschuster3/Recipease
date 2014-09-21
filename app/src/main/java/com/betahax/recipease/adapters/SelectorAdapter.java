package com.betahax.recipease.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.betahax.recipease.R;
import com.betahax.recipease.api.ImageLoadTask;
import com.betahax.recipease.model.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ksudu94 on 9/20/2014.
 */
public class SelectorAdapter extends ArrayAdapter<Recipe> {

    int resource;
    List<Recipe> recipes;

    public SelectorAdapter(Context context, int resource, ArrayList<Recipe> items) {
        super(context, resource);
        this.resource = resource;
        recipes = items;
    }

    public class ViewHolder {
        WebView webRecipe;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Log.v("ConvertView", String.valueOf(position));
        View view = convertView;

        ViewHolder holder;


        // Inflate the view
        if (view == null) {

            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi;
            vi = (LayoutInflater) getContext().getSystemService(inflater);
            view = vi.inflate(R.layout.item_recipe, parent, false);

            holder = new ViewHolder();

            holder.webRecipe = (WebView) view.findViewById(R.id.webRecipe);

            view.setTag(holder);

        } else {

            holder = (ViewHolder) view.getTag();
        }

        Recipe recipe = recipes.get(position);
        String url = recipe.getImageSrc().substring(2, recipe.getImageSrc().length()-2);
        holder.webRecipe.loadData(url, "text/html; charset=UTF-8", null);


        return view;
    }
}
