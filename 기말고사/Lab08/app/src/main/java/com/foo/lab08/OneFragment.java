package com.foo.lab08;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.foo.lab08.databinding.FragmentOneBinding;

public class OneFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentOneBinding binding = FragmentOneBinding.inflate(inflater, container, false);

        binding.button.setOnClickListener(view -> {
            //Fragment 내에서 Activity 객체 획득은 getActivity() 로...
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_content, new TwoFragment())
                    .addToBackStack(null)
                    .commit();
        });

        return binding.getRoot();
    }
}
