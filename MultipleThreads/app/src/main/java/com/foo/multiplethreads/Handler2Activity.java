package com.foo.multiplethreads;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.foo.multiplethreads.databinding.StartCounterBinding;

public class Handler2Activity extends AppCompatActivity {

    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartCounterBinding binding = StartCounterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Handler handler = new MyHandler();

        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        handler.sendMessage(handler.obtainMessage(MyHandler.DEACTIVATE_START_BUTTON, binding.startButton));

                        for (int i = 0; i < 100; i++) {

                            try { Thread.sleep(1000); }
                            catch (InterruptedException e) { throw new RuntimeException(e); }

                            binding.countTextView.setText(Integer.toString(++count));
                        }

                        handler.sendMessage(handler.obtainMessage(MyHandler.ACTIVATE_START_BUTTON, binding.startButton));

                    }
                }).start();
            }
        });
    }

    private class MyHandler extends Handler {
        public static final int ACTIVATE_START_BUTTON = 0;
        public static final int DEACTIVATE_START_BUTTON = 1;

        private MyHandler() { super(Looper.getMainLooper()); }

        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case ACTIVATE_START_BUTTON:
                    ((Button) msg.obj).setEnabled(true);
                    break;
                case DEACTIVATE_START_BUTTON:
                    ((Button) msg.obj).setEnabled(false);
                    break;
            }
        }
    }
}