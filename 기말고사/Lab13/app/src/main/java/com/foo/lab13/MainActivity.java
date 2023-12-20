package com.foo.lab13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.foo.lab13.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = binding.addTitle.getText().toString();
                String content = binding.addContent.getText().toString();
                DBHelper helper = new DBHelper(MainActivity.this);
                SQLiteDatabase db = helper.getWritableDatabase();
                db.execSQL("insert into tb_memo (title, content) values (?, ?)",
                        new String[]{title, content});
                db.close();
                Intent intent = new Intent(MainActivity.this, ReadDBActivity.class);
                startActivity(intent);
            }
        });
    }
}