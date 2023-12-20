package com.example.bottom_navigation_practice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bottom_navigation_practice.databinding.FragmentPlaceBinding;


public class placeFragment extends Fragment {
    FragmentPlaceBinding binding;

    @Override
    public void onResume() {
        super.onResume();
        getParentFragmentManager().setFragmentResultListener("place", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String getresult = result.getString("placeKey");
                binding.firstFragment.setText(getresult);
            }
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPlaceBinding.inflate(inflater, container, false);

        binding.firstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                                .add(R.id.placeLayout, new placeSecondFragment()).commit();

            }
        });


        return binding.getRoot();
    }
}