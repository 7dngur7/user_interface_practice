package com.example.finalexampractice;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalexampractice.databinding.FragmentFourthSecondFramgentBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fourthSecondFramgent#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fourthSecondFramgent extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fourthSecondFramgent() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fourthSecondFramgent.
     */
    // TODO: Rename and change types and number of parameters
    public static fourthSecondFramgent newInstance(String param1, String param2) {
        fourthSecondFramgent fragment = new fourthSecondFramgent();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

            SharedPreferences mydb = getActivity().getSharedPreferences("mydb", Context.MODE_PRIVATE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentFourthSecondFramgentBinding binding = FragmentFourthSecondFramgentBinding.inflate(inflater, container, false);

        SharedPreferences mydb = getActivity().getSharedPreferences("mydb", Context.MODE_PRIVATE);
        String title = mydb.getString("title", "0");
        String content = mydb.getString("content", "0");

        binding.title.setText(title);
        binding.content.setText(content);



     return binding.getRoot();
    }
}