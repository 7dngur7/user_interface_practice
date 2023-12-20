package com.foo.lab10modina;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.foo.lab10modina.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("CJW", "onCreate()");
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        Log.d("CJW", "onActivityResult() - callback");
                        if (o.getResultCode() == RESULT_OK)
                            binding.resultTextView.setText(o.getData().getStringExtra("result"));
                    }
                });

        binding.toDialogActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DialogActivity.class));
            }
        });

        binding.toSecondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        binding.toSecondActivityWithExtraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class).putExtra("extra", "from main activity"));
            }
        });

        binding.toSecondActivityForResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivityForResult(new Intent(MainActivity.this, SecondActivity.class)
//                        .putExtra("extra", "from main activity"), 1000);

                launcher.launch(new Intent(MainActivity.this, SecondActivity.class)
                        .putExtra("extra", "from main activity")
                        .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d("CJW", "onActivityResult()");
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000 && resultCode == RESULT_OK) {
            binding.resultTextView.setText(data.getStringExtra("result"));
        }
    }

    @Override
    protected void onDestroy() {
        Log.d("CJW", "onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        Log.d("CJW", "onStart()");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d("CJW", "onStop()");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.d("CJW", "onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("CJW", "onPause()");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.d("CJW", "onRestart()");
        super.onRestart();
    }

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        Log.d("CJW", "onSaveInstanceState()");
//        super.onSaveInstanceState(outState);
//
//        outState.putString("key", binding.inputEditText.getText().toString());
//    }
////
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        Log.d("CJW", "onRestoreInstanceState()");
//        super.onRestoreInstanceState(savedInstanceState);
//
//        binding.inputEditText.setText(savedInstanceState.getString("key"));
//    }


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        Log.d("CJW", "onConfigurationChanged()");
        super.onConfigurationChanged(newConfig);
    }
}