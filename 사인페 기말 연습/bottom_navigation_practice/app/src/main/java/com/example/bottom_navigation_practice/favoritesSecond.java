package com.example.bottom_navigation_practice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bottom_navigation_practice.databinding.FragmentFavoritesSecondBinding;


public class favoritesSecond extends Fragment {
    FragmentFavoritesSecondBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFavoritesSecondBinding.inflate(inflater, container, false);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("hi", "hihi my bundle");
                getParentFragmentManager().setFragmentResult("bundle",bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .remove(favoritesSecond.this).commit();
            }
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}