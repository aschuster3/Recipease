package com.betahax.recipease.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.betahax.recipease.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ksudu94 on 9/20/2014.
 */
public class QuestionGridAdapter extends ArrayAdapter<String> {

    int resource;
    List<String> questions;

    public QuestionGridAdapter(Context context, int resource, ArrayList<String> items) {
        super(context, resource);
        this.resource = resource;
        questions = items;
    }

    public class ViewHolder {
        TextView tvName;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Log.v("ConvertView", String.valueOf(position));
        ViewHolder holder;


        // Inflate the view
        if (convertView == null) {

            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi;
            vi = (LayoutInflater) getContext().getSystemService(inflater);
            convertView = vi.inflate(R.layout.grid, parent, false);

            holder = new ViewHolder();

            holder.tvName = (TextView) convertView.findViewById(R.id.tvName);

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvName.setText(questions.get(position));

        return convertView;
    }
}
