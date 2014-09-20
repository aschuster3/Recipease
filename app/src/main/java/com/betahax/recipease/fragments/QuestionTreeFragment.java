package com.betahax.recipease.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.betahax.recipease.R;

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

        GridView gv = (GridView) view.findViewById(R.id.grid_view_blaaah);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) adapterView.getAdapter().getItem(i);

                mListener.onQuestionTouch(1);
            }
        });

        return view;
    }

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
    public interface OnQuestionTouchListener {
        // TODO: Update argument type and name
        public void onQuestionTouch(int var);
    }

}
