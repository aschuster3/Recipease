package com.betahax.recipease.fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.betahax.recipease.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.betahax.recipease.fragments.RecipeBookListFragment.OnRecipeSelectionListener} interface
 * to handle interaction events.
 * Use the {@link RecipeBookListFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class RecipeBookListFragment extends ListFragment {

    private OnRecipeSelectionListener mListener;


    public static RecipeBookListFragment newInstance() {
        RecipeBookListFragment fragment = new RecipeBookListFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }
    public RecipeBookListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_book_list, container, false);

        // Inflate the layout for this fragment
        return view;
    }

    /**
     * Creates a new instance
     */
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Notify the parent activity of selected item
        super.onListItemClick(l, v, position, id);
        mListener.OnRecipeSelected();

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnRecipeSelectionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnRecipeSelectionListener");
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
    public interface OnRecipeSelectionListener {
        // TODO: Update argument type and name
        public void OnRecipeSelected();
    }

}
