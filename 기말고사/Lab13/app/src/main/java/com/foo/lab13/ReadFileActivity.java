package com.foo.lab13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;

import com.foo.lab13.databinding.ActivityReadFileBinding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringJoiner;

public class ReadFileActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        ActivityReadFileBinding binding = ActivityReadFileBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        StringJoiner joiner = new StringJoiner("\n");
//
//        File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "test.txt");
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            reader.lines().forEach(joiner::add);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        binding.fileResult.setText(joiner.toString());
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityReadFileBinding binding = ActivityReadFileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // read/write with SharedPreferences

        SharedPreferences localPrefs = getPreferences(MODE_PRIVATE);
        SharedPreferences globalCustomPrefs = getSharedPreferences("my_prefs", MODE_PRIVATE);
        SharedPreferences globalDefaultPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        String data1 = globalCustomPrefs.getString("data1", "none");
        int data2 = globalCustomPrefs.getInt("data2", 0);

        binding.fileResult.setText(data1 + "\n" + data2);
    }
}