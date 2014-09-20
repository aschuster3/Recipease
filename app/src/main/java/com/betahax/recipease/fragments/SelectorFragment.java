package com.betahax.recipease.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.betahax.recipease.OnSwipeTouchListener;
import com.betahax.recipease.R;
import com.betahax.recipease.model.Recipe;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.betahax.recipease.fragments.SelectorFragment.OnSelectorInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SelectorFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class SelectorFragment extends Fragment {

    private static final String List_Position = "listPosition";


    private int listPosition;
    FrameLayout selectorLayout;

    private OnSelectorInteractionListener mListener;

    public static SelectorFragment newInstance() {
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


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_selector, container, false);



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
        public void swipedRight(Recipe recipe, ImageView view);
    }

 }
