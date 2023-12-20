package com.example.a08practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Binder;
import android.os.Bundle;

import com.example.a08practice.databinding.ActivityFragmentPracticeBinding;

public class fragmentPractice extends AppCompatActivity {

    ActivityFragmentPracticeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_practice);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.myfragmentAct, new OneFragment2())
                .commit();

    }
}