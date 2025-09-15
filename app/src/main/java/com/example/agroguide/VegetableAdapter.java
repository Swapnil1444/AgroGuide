package com.example.agroguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VegetableAdapter extends RecyclerView.Adapter<VegetableViewHolder> {
    private List<spineerlist> vegetables;

    public VegetableAdapter(List<spineerlist> vegetables) {
        this.vegetables = vegetables;
    }

    @NonNull
    @Override
    public VegetableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vegetable, parent, false);
        return new VegetableViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VegetableViewHolder holder, int position) {
        spineerlist currentVegetable = vegetables.get(position);
        holder.textViewName.setText(currentVegetable.getName());
        holder.textViewCity.setText(currentVegetable.getLocation());
        holder.textViewDate.setText(currentVegetable.getDate());
        holder.textViewPrice.setText(currentVegetable.getPrice());
    }

    @Override
    public int getItemCount() {
        return vegetables.size();
    }
}
