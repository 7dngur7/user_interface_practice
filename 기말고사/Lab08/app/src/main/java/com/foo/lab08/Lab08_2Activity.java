package com.foo.lab08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Lab08_2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab08_2);

        //androidx.fragment.app.FragmentManager
        //androidx.fragment.app.FragmentTransaction
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_content, new OneFragment())
                .commit();
    }
}