package com.foo.multiplethreads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.foo.multiplethreads.databinding.StartStopCounterBinding;

public class CallbackableServiceActivity extends AppCompatActivity {

    interface CountChangedListener {
        void countChanged(int value);
    }
    private CallbackableBoundedCountService countService;

    private boolean isStopButtonClicked;

    private StartStopCounterBinding binding;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            CallbackableBoundedCountService.ServiceBinder binder = (CallbackableBoundedCountService.ServiceBinder) service;
            countService = binder.getService();
            countService.setOnCountChangedListener(new CountChangedListener() {
                @Override
                public void countChanged(int count) {
                    binding.countTextView.setText(Integer.toString(count));
                }
            });

            Log.d("CallbackableServiceActivity", "onServiceConnected()");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("CallbackableServiceActivity", "onServiceDisconnected()");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = StartStopCounterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countService.setOnCountChangedListener(new CountChangedListener() {
                    @Override
                    public void countChanged(int count) {
                        binding.countTextView.setText(Integer.toString(count));
                    }
                });

                startService(new Intent(getApplicationContext(), CallbackableBoundedCountService.class));
            }
        });

        binding.stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countService.stopCounting();
                isStopButtonClicked = true;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        bindService(new Intent(this, CallbackableBoundedCountService.class), connection, BIND_AUTO_CREATE);
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