package com.hfad.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button addBtn, randemeBtn;
    private int randemeIndex;
    String[] b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();
        initListener();
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