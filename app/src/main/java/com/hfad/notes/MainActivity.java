package com.hfad.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Note> arra;
    FragmentManager manager;
    FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBtnOpenNotes();
        initBtnNotes();
        initToolbar();
    }


    private void initToolbar() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Обработка выбора пункта меню приложения (активити)
        int id = item.getItemId();
        switch (id) {
            case R.id.action_setting:
              //  addFragment(new SettingsFragment());
                return true;
            case R.id.action_main:
               // addFragment(new MainFragment());
                return true;
            case R.id.action_favorit:
                //addFragment(new FavoriteFragment());
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initBtnNotes() {

        NoteFragment noteFragment1 = new NoteFragment();
        ArrayList<Note> arra = noteFragment1.addArray();
        Button buttonNote = findViewById(R.id.buttonNoteBody);
        buttonNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("tramtram", "click");
                Toast.makeText(MainActivity.this, "не работать(", Toast.LENGTH_SHORT).show();
                // addFragment(new OpenNoteFragment(2, noteFragment1.initTV()));
            }
        });
    }

    //Открываем список заметок
    private void initBtnOpenNotes() {
        Button buttonList = findViewById(R.id.buttonNoteList);
        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(new NoteFragment());
            }
        });
    }

    //Открываем  фрагмент
    private void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

}