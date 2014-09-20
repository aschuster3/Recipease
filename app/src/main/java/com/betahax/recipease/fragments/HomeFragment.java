package com.betahax.recipease.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.betahax.recipease.QuestionTree;
import com.betahax.recipease.R;
import com.betahax.recipease.RecipeBook;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnHomeFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class HomeFragment extends Fragment {


    Button btnSearchRecipes;
    Button btnMyRecipes;
    Button btnRandomRecipes;
    private OnHomeFragmentInteractionListener mListener;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        btnSearchRecipes = (Button) rootView.findViewById(R.id.btnSearchRecipes);
        btnRandomRecipes = (Button)rootView.findViewById(R.id.btnRandomRecipes);
        btnMyRecipes = (Button) rootView.findViewById(R.id.btnMyRecipes);

        btnMyRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.OnRecipeBookInteraction();

            }
        });

        btnRandomRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent myIntent = new Intent("com.betahax.recipease.RecipeBook");
                //startActivity(myIntent);
                mListener.OnRandomInteraction();
                Fragment selectorFragment = SelectorFragment.newInstance();
                getFragmentManager().beginTransaction().replace(R.id.container, selectorFragment).addToBackStack("Lol").commit();

            }
        });

        btnSearchRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.OnSearchInteraction();
            }
        });

        return rootView;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnHomeFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHomeFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnHomeFragmentInteractionListener {
        // TODO: Update argument type and name
        public void OnRecipeBookInteraction();
        public void OnRandomInteraction();
        public void OnSearchInteraction();
    }

}
