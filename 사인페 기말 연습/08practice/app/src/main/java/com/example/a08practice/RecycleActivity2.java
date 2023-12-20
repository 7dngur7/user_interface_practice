package com.example.a08practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.example.a08practice.databinding.ActivityRecycle2Binding;
import com.example.a08practice.databinding.ActivityRecycleBinding;
import com.example.a08practice.databinding.ItemBinding;

import java.util.ArrayList;
import java.util.List;

public class RecycleActivity2 extends AppCompatActivity {

    List<String> myList = new ArrayList<>();
    ActivityRecycle2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecycle2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        for(int i = 0; i<100;i++){
            myList.add("item"+i);
        }

        binding.recyclerView.setAdapter(new MyAdapter(myList));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        binding.recyclerView.addItemDecoration();


    }

    public class  MyViewHolder extends RecyclerView.ViewHolder {

        ItemBinding itemBinding;
        public MyViewHolder(@NonNull ItemBinding binding) {
            super(binding.getRoot());
            this.itemBinding = binding;

        }
    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        List<String> list;
        ItemBinding itemBinding;

        public MyAdapter(List<String> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            itemBinding = ItemBinding.inflate(getLayoutInflater(), parent, false);
            return new MyViewHolder(itemBinding);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            String string = list.get(position);
            holder.itemBinding.textView.setText(string);


        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }


}