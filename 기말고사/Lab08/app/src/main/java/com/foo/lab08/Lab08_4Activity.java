package com.foo.lab08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

import com.foo.lab08.databinding.ActivityLab084Binding;

import java.util.Arrays;
import java.util.List;

public class Lab08_4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLab084Binding binding = ActivityLab084Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewpager.setAdapter(new MyPagerAdapter(this));
    }

    private class MyPagerAdapter extends FragmentStateAdapter {

        private List<Fragment> fragments;

        private MyPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            fragments = Arrays.asList(new RedFragment(), new GreenFragment(), new BlueFragment());
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragments.get(position);
        }

        @Override
        public int getItemCount() {
            return fragments.size();
        }
    }
}