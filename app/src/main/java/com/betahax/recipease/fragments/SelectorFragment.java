package com.betahax.recipease.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.betahax.recipease.R;

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
    GestureDetector gestureDetector;

    View.OnTouchListener gestureListener;

    private OnSelectorInteractionListener mListener;

    public static SelectorFragment newInstance(int listPosition) {
        SelectorFragment fragment = new SelectorFragment();
        Bundle args = new Bundle();
        args.putInt(List_Position, listPosition);
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
        return inflater.inflate(R.layout.fragment_selector, container, false);
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
    public interface OnSelectorInteractionListener {
        // TODO: Update argument type and name
        public void OnSelectorInteraction(Uri uri);
    }

 }
