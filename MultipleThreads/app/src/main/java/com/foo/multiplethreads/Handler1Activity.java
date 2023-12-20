package com.foo.multiplethreads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.foo.multiplethreads.databinding.StartCounterBinding;

public class Handler1Activity extends AppCompatActivity {

    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartCounterBinding binding = StartCounterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Handler handler = new Handler(Looper.getMainLooper());

        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                binding.startButton.setEnabled(false);
                            }
                        });

                        for (int i = 0; i < 100; i++) {

                            try { Thread.sleep(1000); }
                            catch (InterruptedException e) { throw new RuntimeException(e); }

                            binding.countTextView.setText(Integer.toString(++count));
                        }

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                binding.startButton.setEnabled(true);
                            };
                        });

                    }
                }).start();
            }
        });
    }
}