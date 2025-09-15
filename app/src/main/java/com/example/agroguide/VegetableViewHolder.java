package com.example.agroguide;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VegetableViewHolder extends RecyclerView.ViewHolder {
    TextView textViewName;
    TextView textViewCity;
    TextView textViewDate;
    TextView textViewPrice;

    public VegetableViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewName = itemView.findViewById(R.id.textViewName);
        textViewCity = itemView.findViewById(R.id.textViewCity);
        textViewDate = itemView.findViewById(R.id.textViewDate);
        textViewPrice = itemView.findViewById(R.id.textViewPrice);
    }
}
