package com.foo.multiplethreads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.foo.multiplethreads.databinding.StartStopCurrentCounterBinding;

public class BoundedServiceActivity extends AppCompatActivity {

    private BoundedCountService countService;

    private boolean isStopButtonClicked;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundedCountService.ServiceBinder binder = (BoundedCountService.ServiceBinder) service;
            countService = binder.getService();
            Log.d("BoundServiceActivity", "onServiceConnected()");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("BoundServiceActivity", "onServiceDisconnected()");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartStopCurrentCounterBinding binding = StartStopCurrentCounterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(), BoundedCountService.class));
            }
        });

        binding.stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countService.stopCounting();
                isStopButtonClicked = true;
            }
        });

        binding.currentCountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.countTextView.setText(Integer.toString(countService.getCurrentCount()));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        bindService(new Intent(this, BoundedCountService.class), connection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(connection);

        if (isStopButtonClicked) {
            stopService(new Intent(this, BoundedCountService.class));
            isStopButtonClicked = false;
        }
    }
}