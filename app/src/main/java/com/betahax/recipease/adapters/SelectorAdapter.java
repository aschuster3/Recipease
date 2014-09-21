package com.betahax.recipease.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.betahax.recipease.R;
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
        TextView tvName;
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
            view = vi.inflate(R.layout.grid, parent, false);

            holder = new ViewHolder();

            holder.tvName = (TextView) view.findViewById(R.id.tvName);

            view.setTag(holder);

        } else {

            holder = (ViewHolder) view.getTag();
        }

        //holder.tvName.setText();

        return view;
    }
}
