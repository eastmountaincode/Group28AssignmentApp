package com.example.group28assignmentapp.database.recyclerviews;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group28assignmentapp.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView view;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        this.view = itemView.findViewById(R.id.randomText);
    }

    public TextView getView() {
        return view;
    }
}
