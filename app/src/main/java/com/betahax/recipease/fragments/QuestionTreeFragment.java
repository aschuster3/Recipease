package com.betahax.recipease.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.betahax.recipease.R;
import com.betahax.recipease.adapters.QuestionGridAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.betahax.recipease.fragments.QuestionTreeFragment.OnQuestionTouchListener} interface
 * to handle interaction events.
 * Use the {@link QuestionTreeFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class QuestionTreeFragment extends Fragment {

    // State markers
    public static final int MEAL_TYPE = 0,
                            BASE = 1,
                            TASTE = 2,
                            COOK_TIME = 3;


    int questionNumber;
    private static final String Question_Number = "questionNumber";
    private OnQuestionTouchListener mListener;

  
    public static QuestionTreeFragment newInstance(int questionNumber) {
        QuestionTreeFragment fragment = new QuestionTreeFragment();
        Bundle args = new Bundle();
        args.putInt(Question_Number, questionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    public QuestionTreeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            questionNumber = getArguments().getInt(Question_Number);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_tree, container, false);

        TextView tv = (TextView) view.findViewById(R.id.grid_header);
        GridView gv = (GridView) view.findViewById(R.id.grid_view_blaaah);

        ArrayList<String> questionComponents = new ArrayList<String>();

        ArrayAdapter<String> adapter;
        // A quick switch to determine what state we're in for display purposes
        switch(questionNumber) {
            case MEAL_TYPE:
                tv.setText("What type of meal are you preparing for?");
                questionComponents.add("Breakfast");
                questionComponents.add("Lunch");
                questionComponents.add("Dinner");
                questionComponents.add("Snack");

                adapter = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_1, questionComponents);
                break;
            case BASE:
                tv.setText("What should the base of your recipes be?");
                questionComponents.add("Chicken");
                questionComponents.add("Beef");
                questionComponents.add("Pork");
                questionComponents.add("Fish");
                questionComponents.add("Tofu");
                questionComponents.add("Vegetarian");
                questionComponents.add("Vegan");

                adapter = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_1, questionComponents);
                break;
            case TASTE:
                tv.setText("How would you like it to taste?");
                questionComponents.add("Sweet");
                questionComponents.add("Spicy");
                questionComponents.add("Savory");
                questionComponents.add("Sour");
                questionComponents.add("Bitter");

                adapter = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_1, questionComponents);
                break;
            case COOK_TIME:
                tv.setText("How much time to you have to prepare the meal?");
                questionComponents.add("<30 minutes");
                questionComponents.add("1 to 2 hours");
                questionComponents.add(">2 hours");

                adapter = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_1, questionComponents);
                break;
            default:
                adapter = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_1, questionComponents);
                break;
        }
        gv.setAdapter(adapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mListener.onQuestionTouch(i);
            }
        });

        return view;
    }

    // TODO reset on back button the states
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnQuestionTouchListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnQuestionTouchListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnQuestionTouchListener {
        public void onQuestionTouch(int var);
    }

}
