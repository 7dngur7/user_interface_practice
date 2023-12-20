package com.example.a10practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.a10practice.databinding.ActivityMainBinding;
import com.example.a10practice.databinding.ActivityThirdBinding;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityThirdBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.finishWithResultButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v== binding.finishWithResultButton){
            setResult(RESULT_OK, new Intent().putExtra("thirdExtra", "thirdExtra"));
        }
    }
}