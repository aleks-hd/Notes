package com.hfad.notes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class OpenNoteFragment extends Fragment {

    TextView tvNameNote, tvDescription, tvDateCreateNote;
    private int index;
ArrayList<Note> arrayList;


    public OpenNoteFragment() {
    }

   public OpenNoteFragment(int index,ArrayList<Note> array) {
        this.index = index;
        this.arrayList = array;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_open_note, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initNote(view,index);
    }

    private void initNote(View v,int i){
        tvNameNote = v.findViewById(R.id.tv_nameNodes);
        tvDescription = v.findViewById(R.id.tv_DescriptionNodes);
        tvDateCreateNote = v.findViewById(R.id.tv_DateCreateNodes);

       if (arrayList == null){
           Log.e("error", "Пустой массив");
       }else {
           Note note = arrayList.get(i);
           tvNameNote.setText(note.getNameNote());
           tvDescription.setText(note.getDescriptionNotes());
           Log.e("ksdjfvns", note.getNameNote() + ";" + note.getDescriptionNotes());
       }  }



}