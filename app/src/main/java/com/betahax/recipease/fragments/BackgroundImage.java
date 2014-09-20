package com.betahax.recipease.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.betahax.recipease.R;



public class BackgroundImage extends Fragment {
    private static final String IMAGE_SRC = "img";

    // TODO: Rename and change types of parameters
    private String imageSrc;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param imageSrc The source of the image for the recipe.
     * @return A new instance of fragment BackgroundImage.
     */
    // TODO: Rename and change types and number of parameters
    public static BackgroundImage newInstance(String imageSrc) {
        BackgroundImage fragment = new BackgroundImage();
        Bundle args = new Bundle();
        args.putString(IMAGE_SRC, imageSrc);

        fragment.setArguments(args);
        return fragment;
    }
    public BackgroundImage() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imageSrc = getArguments().getString(IMAGE_SRC);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_background_image, container, false);

        ((WebView) view.findViewById(R.id.background_image_webview)).loadUrl(imageSrc);

        return view;
    }
}
