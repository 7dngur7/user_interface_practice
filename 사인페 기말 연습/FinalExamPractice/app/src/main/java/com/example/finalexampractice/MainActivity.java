package com.example.finalexampractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.finalexampractice.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        List<String> StringList = new ArrayList<>();
        for(int i=0;i<100;i++){
            StringList.add(""+i);
        }

        BottomNavigationView bottomNavigationView = binding.navigationBar;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_activity, new firstFragment(StringList)).commit();


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.menu1){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_activity, new firstFragment(StringList)).commit();
                    return true;
                }
                else if(item.getItemId() == R.id.menu2){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_activity, new secondFragment()).commit();
                    return true;
                }
                else if(item.getItemId() == R.id.menu3){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_activity, new thirdFragment()).commit();
                    return true;
                }
                else if(item.getItemId() == R.id.menu4){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_activity, new fourthFragment()).commit();
                    return true;
                }
                return true;
            }
        });

        ;
    }

    public void transferTo(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_activity, fragment).commit();

    }
}