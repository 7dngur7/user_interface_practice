package com.example.againfinalexampracitc;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.againfinalexampracitc.databinding.FragmentFirstBinding;
import com.example.againfinalexampracitc.databinding.ItemBinding;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_first#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_first extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<String> list;

    public fragment_first(List<String> list) {
        // Required empty public constructor
        this.list = list;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_first.
     */
    // TODO: Rename and change types and number of parameters
//    public static fragment_first newInstance(String param1, String param2) {
//        fragment_first fragment = new fragment_first();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

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

        FragmentFirstBinding binding = FragmentFirstBinding.inflate(inflater, container, false);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recycler.setAdapter(new MyAdapter(list));



        return binding.getRoot();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ItemBinding binding;
        public MyViewHolder(@NonNull ItemBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;

        }
    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
        List<String> list;
        public MyAdapter(List<String > list) {
            this.list = list;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ItemBinding itemBinding = ItemBinding.inflate(getLayoutInflater(), parent, false);

            return new MyViewHolder(itemBinding);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            String letter = list.get(position);
            holder.binding.itemtext.setText(letter);
            holder.binding.itemButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    makeToast(letter+"번");
                }
            });


        }

        @Override
        public int getItemCount() {
            return  list.size();
        }
    }

    public void makeToast(String string){
        Toast toast = new Toast(getActivity());
        toast.setText(string);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }




}