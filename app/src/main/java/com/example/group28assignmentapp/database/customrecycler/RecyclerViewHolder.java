package com.example.group28assignmentapp.database.customrecycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group28assignmentapp.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private ImageView stickerImage;
    private TextView associatedUser;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        this.associatedUser = itemView.findViewById(R.id.associated_user_text);
        this.stickerImage = itemView.findViewById(R.id.sticker_image);
    }

    public ImageView getStickerImage() {
        return stickerImage;
    }

    public void setStickerImage(ImageView stickerImage) {
        this.stickerImage = stickerImage;
    }

    public TextView getAssociatedUser() {
        return associatedUser;
    }

    public void setAssociatedUser(TextView associatedUser) {
        this.associatedUser = associatedUser;
    }
}
