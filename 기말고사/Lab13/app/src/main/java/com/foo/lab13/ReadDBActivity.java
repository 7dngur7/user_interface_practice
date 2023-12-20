package com.foo.lab13;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.foo.lab13.databinding.ActivityReadDbactivityBinding;

public class ReadDBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityReadDbactivityBinding binding = ActivityReadDbactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select title, content from tb_memo order by _id desc limit 2", null);
        while (cursor.moveToNext()) {
            binding.readTitle.setText(cursor.getString(0));

            binding.readContent.setText(cursor.getString(1));
        }
        db.close();
    }
}