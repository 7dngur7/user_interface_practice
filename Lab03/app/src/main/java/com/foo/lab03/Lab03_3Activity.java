package com.foo.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lab03_3Activity extends AppCompatActivity implements View.OnClickListener {
    Button trueBtn;
    TextView targetTextView;
    Button fasleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab03_3);

        // View 객체 획득
        trueBtn = findViewById(R.id.btn_visible_true);
        targetTextView = findViewById(R.id.text_visible_target);
        fasleBtn = findViewById(R.id.btn_visible_false);

        // Button 이벤트 등록
        trueBtn.setOnClickListener(this);
        fasleBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == trueBtn) {
            // trueBtn이 눌리면 targetTextView를 visible 상태로 변경
            targetTextView.setVisibility(View.VISIBLE);
        } else if (v == fasleBtn) {
            // falseBtn 눌리면 targetTextView를 invisible 상태로 변경
            targetTextView.setVisibility(View.INVISIBLE);
        }
    }
}