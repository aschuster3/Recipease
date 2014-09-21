package com.betahax.recipease.fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.betahax.recipease.InfoActivity;
import com.betahax.recipease.R;
import com.betahax.recipease.RecipeBook;
import com.betahax.recipease.api.ImageLoadTask;
import com.betahax.recipease.model.Recipe;
import com.betahax.recipease.adapters.SelectorAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.betahax.recipease.fragments.SelectorFragment.OnSelectorInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SelectorFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class SelectorFragment extends Fragment{

    private static final String List_Position = "listPosition";


    private int listPosition;
    ArrayList<Recipe> recipeArray;

    ListView lv;
    WebView recipe_preview;
    TextView recipe_name;
    Button yes_button, info_button;

    int count;

    private SelectorAdapter selectorAdapter;

    private OnSelectorInteractionListener mListener;

    public static SelectorFragment newInstance( ArrayList<Recipe> recipeArrayFromActivity) {
        SelectorFragment fragment = new SelectorFragment();
        Bundle args = new Bundle();
        args.putSerializable("recipeArrayFromActivity", recipeArrayFromActivity);
        fragment.setArguments(args);
        return fragment;
    }

    public SelectorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Add your menu entries here
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            listPosition = getArguments().getInt(List_Position);
            recipeArray = (ArrayList<Recipe>) getArguments().getSerializable("recipeArrayFromActivity");
        }

        count = 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_selector, container, false);

        recipe_name = (TextView) rootView.findViewById(R.id.recipe_name);
        recipe_preview = (WebView) rootView.findViewById(R.id.recipe_preview);
        yes_button = (Button) rootView.findViewById(R.id.yes_button);
        info_button = (Button) rootView.findViewById(R.id.info_button);
        recipe_preview.setBackgroundColor(Color.argb(1, 0, 0, 0));
        recipe_preview.getSettings().setLoadWithOverviewMode(true);
        recipe_preview.getSettings().setUseWideViewPort(true);
        selectorAdapter = new SelectorAdapter(getActivity(),
                R.layout.item_recipe, recipeArray);

        mListener.populate(recipe_preview, recipe_name, recipeArray, count);
        yes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count ++;
                mListener.populate(recipe_preview, recipe_name, recipeArray, count);
            }
        });

        info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), InfoActivity.class);
                myIntent.putExtra("imageSrc", recipeArray.get(count).getImageSrc());
                myIntent.putExtra("recipeName", recipeArray.get(count).getName());

                startActivity(myIntent);
            }
        });
        return rootView;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnSelectorInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnSelectorInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void getNextPicture(WebView view, TextView recipe_name, ArrayList<Recipe> recipeInputArray, int count) {

        //Callback
    }
    public interface OnSelectorInteractionListener {
        public void populate(WebView view, TextView recipe_name, ArrayList<Recipe> recipeInputArray, int count);
        public void swipedLeft();
        public void swipedRight(Recipe recipe, WebView image);
    }

 }
