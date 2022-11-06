package com.example.group28assignmentapp.database.sendUI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group28assignmentapp.R;

public class StickerRecyclerAdapter extends RecyclerView.Adapter<StickerRecyclerAdapter.StickerViewHolder>{
    String currentUser;
    private StickerRecyclerAdapter.RecyclerViewClickListener listener;
    private Context context;


    public StickerRecyclerAdapter(String currentUser, StickerRecyclerAdapter.RecyclerViewClickListener listener) {
        this.currentUser = currentUser;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StickerRecyclerAdapter.StickerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);
        this.context = parent.getContext();
        return new StickerViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull StickerRecyclerAdapter.StickerViewHolder holder, int position) {
        holder.getSticker().setImageDrawable(AppCompatResources.getDrawable(this.context, R.drawable.pavlu));

    }

    @Override
    public int getItemCount() {
        return 4;
    }


    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

    public class StickerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView sticker;

        public StickerViewHolder(@NonNull View itemView) {
            super(itemView);
            this.sticker = itemView.findViewById(R.id.sticker_image);
            itemView.setOnClickListener(this);
        }

        public ImageView getSticker() {
            return sticker;
        }

        public void setUser(ImageView sticker) {
            this.sticker = sticker;
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());

        }
    }
}
