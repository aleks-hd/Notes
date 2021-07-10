package com.hfad.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {
    private Button addBtn, randemeBtn;
    private int randemeIndex;
    String[] b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.containertoolbar);
        initButton();
        initListener();

        initToolbar();

    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolBarContainer);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_favorite:
                Toast.makeText(MainActivity.this, "Избранные", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, "Настройки", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_main:
                Toast.makeText(MainActivity.this, "Главная", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) search.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    void initButton() {
        addBtn = findViewById(R.id.addBtn);
        randemeBtn = findViewById(R.id.randomeBtn);
        b = getResources().getStringArray(R.array.nameArray);


    }

    void initListener() {
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OneFragment oneFragment = new OneFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, oneFragment)
                        .commit();
            }
        });
        randemeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TwoFragment twoFragment = new TwoFragment(randemeIndex);
                randemeIndex = 0 + (int) (Math.random() * b.length);
                Log.d("RANDOME", randemeIndex + "");
                // twoFragment.setArguments(getIntent().getExtras());
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, twoFragment)
                        .commit();
            }
        });
    }

}