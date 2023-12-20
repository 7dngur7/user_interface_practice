package com.example.recyclerpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerpractice.databinding.ActivityMainBinding;
import com.example.recyclerpractice.databinding.ItemBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> list = new ArrayList<>();
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        for(int i=0;i<100;i++){
            list.add("리사이클"+i);
        }

        binding.recyclelerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclelerView.setAdapter(new recycleAdapter(list));

    }

    public class recycleViewHolder extends RecyclerView.ViewHolder{
        ItemBinding itemBinding;
        public recycleViewHolder(@NonNull ItemBinding itemBinding) {
            super(itemBinding.getRoot());

            this.itemBinding = itemBinding;
        }
    }

    public class recycleAdapter extends RecyclerView.Adapter<recycleViewHolder>{

        List<String> itemlist = new ArrayList<>();
        public recycleAdapter(List<String> itemlist) {
            this.itemlist = itemlist;
        }

        @NonNull
        @Override
        public recycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ItemBinding binding1 = ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

            return new recycleViewHolder(binding1);
        }

        @Override
        public void onBindViewHolder(@NonNull recycleViewHolder holder, int position) {
            String putListString = itemlist.get(position);
            holder.itemBinding.itemTextView.setText(putListString);

        }

        @Override
        public int getItemCount() {
            return itemlist.size();
        }


    }
}