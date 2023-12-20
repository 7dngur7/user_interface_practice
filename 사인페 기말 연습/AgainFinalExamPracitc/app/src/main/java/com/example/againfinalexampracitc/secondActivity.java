package com.example.againfinalexampracitc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentResultListener;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.againfinalexampracitc.databinding.ActivitySecondBinding;

public class secondActivity extends AppCompatActivity {
    ActivitySecondBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = ActivitySecondBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        String fromfragment = getIntent().getStringExtra("hisecond");
    binding.intent2Button.setText(fromfragment);

    binding.intent2Button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.putExtra("fromact", "fromactㅋㅋ");
            setResult(1000, intent);
            finish();



        }
    });

    binding.bottomButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            bottomFragment bottomFragment = new bottomFragment();
            bottomFragment.show(getSupportFragmentManager(), bottomFragment.getTag());


        }

    });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}