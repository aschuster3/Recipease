package com.betahax.recipease.fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.betahax.recipease.R;
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

    private SelectorAdapter selectorAdapter;

    private OnSelectorInteractionListener mListener;

    public static SelectorFragment newInstance( ArrayList<Recipe> recipeArrayFromActivity) {
        SelectorFragment fragment = new SelectorFragment();
        Bundle args = new Bundle();
        args.putSerializable("recipeArray", recipeArrayFromActivity);
        fragment.setArguments(args);
        return fragment;
    }

    public static SelectorFragment newInstance( ) {
        SelectorFragment fragment = new SelectorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    public SelectorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            listPosition = getArguments().getInt(List_Position);
        }
        recipeArray = (ArrayList<Recipe>) getArguments().getSerializable("recipeArray");



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_selector, container, false);

        recipe_preview = (WebView) rootView.findViewById(R.id.recipe_preview);
        selectorAdapter = new SelectorAdapter(getActivity(),
                R.layout.item_recipe, recipeArray);
        //String url = recipeArray.get(2).getImageSrc().substring(7, recipeArray.get(1).getImageSrc().length()-2);

        //recipe_preview.loadUrl(url);

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

    public interface OnSelectorInteractionListener {
        public void populate(WebView image, TextView text);
        public void swipedLeft();
        public void swipedRight(Recipe recipe, WebView image);
    }

 }
