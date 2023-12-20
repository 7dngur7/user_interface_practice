package com.example.finalexampractice;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.finalexampractice.databinding.FragmentFirstBinding;
import com.example.finalexampractice.databinding.ItemBinding;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link firstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class firstFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<String> listString;

    public firstFragment(List<String> listString) {
        this.listString = listString;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment firstFragment.
     */
    // TODO: Rename and change types and number of parameters
//    public static firstFragment newInstance(String param1, String param2) {
//        firstFragment fragment = new firstFragment();
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
        // Inflate the layout for this fragment
        FragmentFirstBinding binding = FragmentFirstBinding.inflate(inflater, container, false);

        RecyclerView recyclerView = binding.recycler;

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new myAdapter());



        return binding.getRoot();
    }

    public  class  myViewholder extends RecyclerView.ViewHolder {

        ItemBinding itemBinding;
        public myViewholder(@NonNull ItemBinding itemBinding) {
            super(itemBinding.getRoot());

            this.itemBinding = itemBinding;
        }

    }

    public class myAdapter extends RecyclerView.Adapter<myViewholder>{
        List<String> list;
        public myAdapter() {
        }

        @NonNull
        @Override
        public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ItemBinding itemBinding1 = ItemBinding.inflate(getLayoutInflater(), parent, false);

            return new myViewholder(itemBinding1);
        }

        @Override
        public void onBindViewHolder(@NonNull myViewholder holder, int position) {
            ItemBinding itemBinding = holder.itemBinding;
            itemBinding.itemtext.setText("dd");

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }



    public void makeToast(String string){
        Toast toast = new Toast(getActivity());
        toast.setText(string+"누름");
        toast.show();

    }

}