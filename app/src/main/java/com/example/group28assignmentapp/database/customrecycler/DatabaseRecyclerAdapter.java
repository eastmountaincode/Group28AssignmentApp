package com.example.group28assignmentapp.database.customrecycler;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group28assignmentapp.database.Sticker;
import com.example.group28assignmentapp.web_service.RecyclerAdapter;

import java.util.List;

public class DatabaseRecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    List<Sticker> stickers;

    public DatabaseRecyclerAdapter(List<Sticker> stickers) {
        this.stickers = stickers;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
