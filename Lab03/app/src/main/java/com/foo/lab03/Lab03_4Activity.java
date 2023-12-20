package com.foo.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;

import com.foo.lab03.databinding.ActivityLab034Binding;

public class Lab03_4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lab03_4);

        ActivityLab034Binding binding = ActivityLab034Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    binding.checkbox.setText("is Checked");
                } else {
                    binding.checkbox.setText("is unChecked");
                }
            }
        });
    }
}