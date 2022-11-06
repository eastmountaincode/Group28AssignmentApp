package com.example.group28assignmentapp.database.recyclerviews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group28assignmentapp.R;
import com.example.group28assignmentapp.database.Sticker;

import java.util.List;

public class DatabaseListAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private List<Sticker> listOfReceivedStickers;

    public DatabaseListAdapter(List<Sticker> listOfReceivedStickers) {
        this.listOfReceivedStickers = listOfReceivedStickers;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        String nth_item = listOfReceivedStickers.get(position).toString();
        holder.getAssociatedUserView().setText(listOfReceivedStickers.get(position)
                .getAssociatedUser());
        holder.getStickerView().setText(listOfReceivedStickers.get(position)
                .getSticker_number().toString());
    }

    @Override
    public int getItemCount() {
        return this.listOfReceivedStickers.size();
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.frame_textview;
    }
}
