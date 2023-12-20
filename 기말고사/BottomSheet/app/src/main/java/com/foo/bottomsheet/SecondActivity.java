package com.foo.bottomsheet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class SecondActivity extends AppCompatActivity {
    private BottomSheetDialog dialog;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        resultTextView = findViewById(R.id.result);

        dialog = new BottomSheetDialog(this);

        Button button = findViewById(R.id.show_bottom_sheet_dialog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View contentView = SecondActivity.this.getLayoutInflater().inflate(R.layout.bottom_sheet, null);
                dialog.setContentView(contentView);

                attachListenerToContentView(contentView);

                dialog.show();
            }
        });
    }

    private void attachListenerToContentView(View contentView) {
        Button okButton = contentView.findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Switch onOff = contentView.findViewById(R.id.on_off_switch);
                resultTextView.setText(onOff.isChecked() ? "ON" : "OFF");

                dialog.dismiss();
            }
        });
    }


}