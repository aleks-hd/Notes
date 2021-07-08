package com.hfad.notes;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class NoteFragment extends Fragment {

    public static final String NUM_NOTE = "numberNote";
    public static final String ARRAY_NOTE = "arrayNote";
    int positionNote;
    ArrayList<Note> arrayList;
    Note note;
    FragmentManager manager;
    FragmentTransaction transaction;
    Note note1 = new Note();

    public ArrayList<Note> addArray(){
        return this.arrayList;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //сохраняем позицию выбранного эл-та
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState != null) {
            positionNote = savedInstanceState.getInt(NUM_NOTE);
        }
        initTV();
        getNotes(view, positionNote);
        if (savedInstanceState != null) {
            showNote(positionNote);
        }
    }

    //Записываем в массив объекты
     ArrayList<Note> initTV() {
        arrayList = new ArrayList<>();

        String[] nameArray = getResources().getStringArray(R.array.nameArray);
        String[] DescriptionArray = getResources().getStringArray(R.array.DescriptionArray);
        int[] dateArray = getResources().getIntArray(R.array.DateArray);

        for (int i = 0; i < nameArray.length; i++) {
            note = new Note();
            note.setNameNote(nameArray[i]);
            note.setDescriptionNotes(DescriptionArray[i]);
            note.setDateCreateNotes(dateArray[i]);
            arrayList.add(note);
        }
    return  arrayList;
    }

    private void getNotes(View v, int posi) {
        LinearLayout layout = (LinearLayout) v;

        try {
            for (int i = 0; i < arrayList.size(); i++) {
                note1 = arrayList.get(i);
                String name = note1.getNameNote();
                TextView tv = new TextView(getContext());
                tv.setText(name);
                tv.setTextSize(30);
                layout.addView(tv);
                Log.e("!!!!", note1.getNameNote() + "");
                final int fi = i;
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        positionNote = fi;
                        showNote(positionNote);
                    }
                });
            }
        } catch (Exception e) {
            Log.e("error", "error");
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NUM_NOTE, positionNote);
        outState.putSerializable(ARRAY_NOTE, arrayList);
    }


    //метод который показывает заметку во врагменте
    private void showNote(int i) {
        OpenNoteFragment openNoteFragment = new OpenNoteFragment(i, arrayList);
        manager = requireActivity().getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, openNoteFragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();

    }

}