package com.foo.bottomsheet;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.ok_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView result = findViewById(R.id.result);
                Switch onOff = findViewById(R.id.on_off_switch);
                result.setText(onOff.isChecked() ? "ON" : "OFF");
            }
        });

//        // 디바이스 스크린 높이 알아내기
//        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
//        int height = displayMetrics.heightPixels;
//        int maxHeight = (int) (height*0.5);
//
//        // bottom sheet의 최대 높이 설정
//        BottomSheetBehavior<View> bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottom_sheet));
//        bottomSheetBehavior.setMaxHeight(maxHeight);
    }
}