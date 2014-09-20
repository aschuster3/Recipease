package com.betahax.recipease;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by ksudu94 on 9/20/2014.
 */
public class GroceryListAdapter extends ArrayAdapter<String> {

    int resource;
    List<String> Groceries;


    public GroceryListAdapter(Context context, int resource,
                              ArrayList<String> items) {
        super(context, resource, items);
        this.resource = resource;
        Groceries = items;
    }


    public class ViewHolder {

        TextView tvName;
        TextView tvAmount;
    }

    /**
     * The holder is the container for each list item defined in the ViewHolder class. Below we
     * define them and find out what the equivalent is in our xml file
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.v("ConvertView", String.valueOf(position));
        ViewHolder holder = null;


        // Inflate the view
        if (convertView == null) {

            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi;
            vi = (LayoutInflater) getContext().getSystemService(inflater);
            convertView = vi.inflate(R.layout.grocery_item, null);

            holder = new ViewHolder();

            holder.tvName = (TextView) convertView.findViewById(R.id.tvName);

            holder.tvAmount = (TextView) convertView.findViewById(R.id.tvAmount);

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        //Do Stuff

        return convertView;

    }

}