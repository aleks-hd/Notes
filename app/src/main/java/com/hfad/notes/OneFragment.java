package com.hfad.notes;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


public class OneFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";


    private Integer index;


    public static OneFragment newInstance(Integer index) {
        OneFragment fragment = new OneFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, index);
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

        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initTextViev(view);
        // initPopupMenu(view);
    }

    private void initPopupMenu(View view, View tv, int index) {
        Activity activity = requireActivity();
        PopupMenu popupMenu = new PopupMenu(activity, tv);
        activity.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.item0_popup:
                        initnewFragment(index);
                        return true;
                    case R.id.item1_popup:
                        Toast.makeText(getContext(), "Удалить", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.item2_popup:
                        Toast.makeText(getContext(), "Изменить", Toast.LENGTH_SHORT).show();
                        return true;
                }

                return false;

            }
        });
        popupMenu.show();
    }

    void initTextViev(View view) {
        LinearLayout linearLayout = view.findViewById(R.id.containerTextView);
        String[] arrayName = getResources().getStringArray(R.array.nameArray);
        for (int i = 0; i < arrayName.length; i++) {
            TextView tv = new TextView(getContext());
            tv.setText(arrayName[i]);
            tv.setTextSize(25);
            linearLayout.addView(tv);
            Integer index = i;
            tv.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), "Что бы открыть фрагмент ужерживайте нажитие", Toast.LENGTH_SHORT).show();

                    // initnewFragment(index);
                    initPopupMenu(view, tv, index);
                }
            });
        }
    }

    void initnewFragment(Integer index) {
        TwoFragment twoFragment = TwoFragment.newInstance(index);
        FragmentManager fragManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragTransaction = fragManager.beginTransaction();
        fragTransaction.replace(R.id.fragmentContainer, twoFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
