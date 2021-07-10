package com.hfad.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
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
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
    private Button addBtn, randemeBtn;
    private int randemeIndex;
    String[] b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dravler_main);
        initButton();
        initListener();

        initToolbar();

    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolBarContainer);
        setSupportActionBar(toolbar);
        initDrawer(toolbar);
    }

    void initDrawer(Toolbar toolbar) {
        final DrawerLayout drawerLayout = findViewById(R.id.drawler_lauoyt);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (registeryClick(id)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }
                return false;
            }
        });

    }

    //метод для обработки кливок как из контекстного так и из бокового менб
    boolean registeryClick(int id) {

        switch (id) {
            case R.id.action_favorite:
                Toast.makeText(MainActivity.this, "Избранные", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                openSetting();
                Toast.makeText(MainActivity.this, "Настройки", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_main:
                Toast.makeText(MainActivity.this, "Главная", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }

    private void openSetting() {
        SettingsFragment settingsFragment = new SettingsFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, settingsFragment)
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        registeryClick(id);


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