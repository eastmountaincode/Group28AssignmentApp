package com.example.group28assignmentapp.database.history;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.group28assignmentapp.R;
import com.example.group28assignmentapp.database.sendUI.StickerRecyclerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class HistoryRecyclerAdapter extends RecyclerView.Adapter<HistoryRecyclerAdapter.HistoryViewHolder>  {
    private String currentUser;
    private Context context;
    private ArrayList<Drawable> stickerList;
    private ArrayList<Integer> countList;

    public HistoryRecyclerAdapter(String currentUser, ArrayList<Integer> countList) {
        this.currentUser = currentUser;
        this.countList = countList;
    }


    @NonNull
    @Override
    public HistoryRecyclerAdapter.HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);
        this.context = parent.getContext();
        this.stickerList = new ArrayList<>(Arrays.asList(AppCompatResources.getDrawable(this.context, R.drawable.pavlu),
                AppCompatResources.getDrawable(this.context, R.drawable.clark),
                AppCompatResources.getDrawable(this.context, R.drawable.feinberg),
                AppCompatResources.getDrawable(this.context, R.drawable.park)));
        return new HistoryRecyclerAdapter.HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryRecyclerAdapter.HistoryViewHolder holder, int position) {
        holder.getSticker().setImageDrawable(stickerList.get(position));
        holder.getText().setText("# sent =  " + String.valueOf(countList.get(position)));

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        private ImageView sticker;
        private TextView text;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.sticker = itemView.findViewById(R.id.sticker_image);
            this.text = itemView.findViewById(R.id.associated_user_text);

        }

        public ImageView getSticker() {
            return sticker;
        }

        public void setSticker(ImageView sticker) {
            this.sticker = sticker;
        }

        public TextView getText() {
            return text;
        }

        public void setText(TextView text) {
            this.text = text;
        }
    }
}