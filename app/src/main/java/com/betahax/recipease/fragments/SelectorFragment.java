package com.betahax.recipease.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.betahax.recipease.OnSwipeTouchListener;
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
    FrameLayout selectorLayout;
    TextView tvTest;

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
        tvTest = (TextView) rootView.findViewById(R.id.tvTest);
        selectorLayout = (FrameLayout) rootView.findViewById(R.id.selectorLayout);
        tvTest.setOnTouchListener(new OnSwipeTouchListener(getActivity()) {
            @Override
            public void onSwipeLeft() {
                // Whatever
                Toast toast = Toast.makeText(getActivity(), "Left", Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
        public void onSwipeRight () {
                Toast toast = Toast.makeText(getActivity(), "Right", Toast.LENGTH_SHORT);
                toast.show();
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
        public void OnSelectorInteraction();
    }

 }
