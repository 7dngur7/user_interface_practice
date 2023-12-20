package com.example.againfinalexampracitc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.againfinalexampracitc.databinding.FragmentThirdTwoBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_third_two#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_third_two extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_third_two() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_third_two.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_third_two newInstance(String param1, String param2) {
        fragment_third_two fragment = new fragment_third_two();
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentThirdTwoBinding fragmentThirdTwoBinding = FragmentThirdTwoBinding.inflate(inflater, container, false);


        Bundle bundle = getArguments();
        String string = bundle.getString("fromthird");
        fragmentThirdTwoBinding.thirdFragmentText.setText(string);

        Bundle bundle1 = new Bundle();
        bundle1.putString("key3", "dfjksdjfklsjf");

        fragmentThirdTwoBinding.thirdFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().setFragmentResult("bundle3", bundle1);
            }
        });



        // Inflate the layout for this fragment
        return fragmentThirdTwoBinding.getRoot();
    }
}