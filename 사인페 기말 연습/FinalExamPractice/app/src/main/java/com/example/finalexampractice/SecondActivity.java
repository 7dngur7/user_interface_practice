package com.example.finalexampractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.finalexampractice.databinding.ActivitySecondBinding;
import com.example.finalexampractice.databinding.BottomSheetBinding;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySecondBinding binding = ActivitySecondBinding.inflate(getLayoutInflater());
        String from1 = getIntent().getStringExtra("key1");
        setContentView(binding.getRoot());
        binding.intent2Button.setText(from1);
        binding.intent2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("key2", "from222");
                setResult(1000, intent);
                finish();
            }
        });


        binding.bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheet bottomSheet = new bottomSheet();
                bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());


                SharedPreferences mydb = getSharedPreferences("mydb", MODE_PRIVATE );
                String mydbstring = mydb.getString("bottom", "0");
                binding.intent2Button.setText(mydbstring);
            }
        });



    }



}