package com.example.a08practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a08practice.databinding.ActivityRecycleBinding;
import com.example.a08practice.databinding.ItemBinding;

import java.util.List;

public class RecycleActivity extends AppCompatActivity {
    ActivityRecycleBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecycleBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        binding.recyclerView.setAdapter(new Adapter());

    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemBinding itemBinding;

        public ViewHolder(ItemBinding itemBinding) {
            super(itemBinding.getRoot());
            // Define click listener for the ViewHolder's View
            this.itemBinding = itemBinding;
        }

    }

    public class Adapter extends RecyclerView.Adapter<ViewHolder>{
        private List<String> list;

        public Adapter(List<String> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new ViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

}