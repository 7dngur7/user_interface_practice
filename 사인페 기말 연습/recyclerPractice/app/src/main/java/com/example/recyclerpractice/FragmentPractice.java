package com.example.recyclerpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.recyclerpractice.databinding.ActivityFragmentPracticeBinding;

public class FragmentPractice extends AppCompatActivity {
    ActivityFragmentPracticeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFragmentPracticeBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_fragment_practice);



        getSupportFragmentManager().beginTransaction().add(binding.fragmentPractice.getId(), new firstFragment()).commit();
    }
}