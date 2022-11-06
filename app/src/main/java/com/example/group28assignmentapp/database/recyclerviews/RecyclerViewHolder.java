package com.example.group28assignmentapp.database.recyclerviews;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group28assignmentapp.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView associatedUserView;
    private TextView stickerIDView;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        this.associatedUserView = itemView.findViewById(R.id.randomText);
        this.stickerIDView = itemView.findViewById(R.id.randomText2);
    }

    public TextView getAssociatedUserView() {
        return associatedUserView;
    }

    public TextView getStickerView() {
        return stickerIDView;
    }
}
