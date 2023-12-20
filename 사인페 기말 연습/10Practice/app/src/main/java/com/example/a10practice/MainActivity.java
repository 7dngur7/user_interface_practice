package com.example.a10practice;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;

import com.example.a10practice.databinding.ActivityDialogBinding;
import com.example.a10practice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;
    ActivityResultLauncher<Intent>launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toDialogActivityButton.setOnClickListener(this);
        binding.toSecondActivityButton.setOnClickListener(this);
        binding.toSecondActivityWithExtraButton.setOnClickListener(this);
        binding.toSecondActivityForResultButton.setOnClickListener(this);

            launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        binding.resultTextView.setText(o.getData().getStringExtra("fromExtra"));
                    }
                });
    }


    @Override
    public void onClick(View view) {
        if(view == binding.toDialogActivityButton){
            startActivity(new Intent(MainActivity.this, DialolgActivity.class));
        }
        else if(view == binding.toSecondActivityButton){
            startActivity(new Intent(MainActivity.this, SecondActivity.class));
        }
        else if(view ==binding.toSecondActivityWithExtraButton){
            startActivity(new Intent(MainActivity.this, SecondActivity.class).putExtra("extra", "from main Activity"));
        }
        else if(view == binding.toSecondActivityForResultButton){
            launcher.launch(new Intent(MainActivity.this, SecondActivity.class)
                    .addFlags()

            );
        }
    }
}