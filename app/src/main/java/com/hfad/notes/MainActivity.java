package com.hfad.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    FragmentManager manager;
    FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            recreate();
            return;
        }*/
      /*  if (savedInstanceState == null){
            OpenNoteFragment openNoteFragment = new OpenNoteFragment();
            openNoteFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.note_fragment, openNoteFragment)
                    .commit();
        }*/
     /*   manager = getSupportFragmentManager();
        fragment = new NoteFragment();
        transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_one, fragment);
        transaction.commit();
*/
    }


}