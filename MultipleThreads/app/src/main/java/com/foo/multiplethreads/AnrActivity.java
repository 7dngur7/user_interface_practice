package com.foo.multiplethreads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.foo.multiplethreads.databinding.StartCounterBinding;

public class AnrActivity extends AppCompatActivity {

    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartCounterBinding binding = StartCounterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < 100; i++) {

                    try { Thread.sleep(1000); }
                    catch (InterruptedException e) { throw new RuntimeException(e); }

                    binding.countTextView.setText(Integer.toString(++count));
                }
            }
        });
    }
}