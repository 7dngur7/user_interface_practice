package com.foo.lab13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import com.foo.lab13.databinding.ActivityLab132Binding;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Lab13_2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLab132Binding binding = ActivityLab132Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        binding.btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 외장, 앱별 read/write
//                File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "test.txt");
//                // 파일이 없다면 새로 만들어 준다.
//                if (!file.exists()) {
//                    try {
//                        file.createNewFile();
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//
//                try (FileWriter writer = new FileWriter(file, false)) {
//                    writer.write(binding.content.getText().toString());
//                    writer.flush();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//
//                Toast.makeText(Lab13_2Activity.this, "file save ok", Toast.LENGTH_SHORT).show();
//
//                Intent intent = new Intent(Lab13_2Activity.this, ReadFileActivity.class);
//                startActivity(intent);
//            }
//        });

        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // read/write with SharedPreferences

                SharedPreferences localPrefs = getPreferences(MODE_PRIVATE);
                SharedPreferences globalCustomPrefs = getSharedPreferences("my_prefs", MODE_PRIVATE);
                SharedPreferences globalDefaultPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

                SharedPreferences.Editor editor = globalCustomPrefs.edit();
                editor.putString("data1", "hello");
                editor.putInt("data2", 100);
                editor.commit();

                Toast.makeText(Lab13_2Activity.this, "file save ok", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Lab13_2Activity.this, ReadFileActivity.class);
                startActivity(intent);
            }
        });
    }
}