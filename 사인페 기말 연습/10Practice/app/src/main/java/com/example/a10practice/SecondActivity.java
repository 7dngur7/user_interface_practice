package com.example.a10practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.a10practice.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    ActivitySecondBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fromMainActivityTextView.setText(getIntent().getStringExtra("extra"));

        binding.finishButton.setOnClickListener(this);
        binding.finishWithResultButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v==binding.finishButton){
            finish();
        } else if (v == binding.finishWithResultButton) {
            startActivity(new Intent(SecondActivity.this, ThirdActivity.class).setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT));
        }


    }
}