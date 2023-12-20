package com.example.finalexampractice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalexampractice.databinding.FragmentThirdTwoBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link thirdTwoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class thirdTwoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public thirdTwoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment thirdTwoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static thirdTwoFragment newInstance(String param1, String param2) {
        thirdTwoFragment fragment = new thirdTwoFragment();
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
        FragmentThirdTwoBinding binding = FragmentThirdTwoBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        Bundle bundle = getArguments();
        String answer = bundle.getString("key1");

        binding.thirdFragmentText.setText(answer);
        binding.thirdFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle1 = new Bundle();
                bundle1.putString("key2String", "from3333333333");
                getParentFragmentManager().setFragmentResult("key2", bundle1);


            }
        });


     return binding.getRoot();
    }
}