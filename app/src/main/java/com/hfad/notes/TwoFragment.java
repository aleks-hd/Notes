package com.hfad.notes;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class TwoFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";


    private Integer index;

    public TwoFragment() {

    }

    public TwoFragment(Integer index) {
        this.index = index;
    }


    public static TwoFragment newInstance(Integer param1) {
        TwoFragment fragment = new TwoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initImage(view);
    }

    void initImage(View view) {
        AppCompatImageView imageView = view.findViewById(R.id.containerImage);
        TypedArray image = getResources().obtainTypedArray(R.array.arrayImage);
        imageView.setImageResource(image.getResourceId(index, -1));
    }
}