package com.betahax.recipease;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ksudu94 on 9/20/2014.
 */
public class QuestionGridAdapter extends ArrayAdapter<String> {

    int resource;
    List<String> questions;

    public QuestionGridAdapter(Context context, int resource,   ArrayList<String> items) {
        super(context, resource);
        this.resource = resource;
        questions = items;
    }
}
