package com.example.group28assignmentapp.database.customrecycler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group28assignmentapp.R;
import com.example.group28assignmentapp.database.Sticker;
import com.example.group28assignmentapp.web_service.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class DatabaseRecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    ArrayList<Sticker> stickers;
    private final static String TAG = "REALTIME-DATABASE-ADAPTER";
    private Context context;

    public DatabaseRecyclerAdapter(Context context, ArrayList<Sticker> stickers) {
        this.stickers = stickers;
        this.context = context;
        Log.d(TAG, this.stickers.toString());
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, this.stickers.toString());
        // Create a new view, which defines the UI of the list item
         View view = LayoutInflater.from(parent.getContext())
                 .inflate(R.layout.recycler_view_item, parent, false);
         return new RecyclerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.getAssociatedUser().setText(stickers.get(position).getAssociatedUser());

        // Handle converting strings into resource ids
        String stickerNumber = stickers.get(position).getSticker_number();
        int id = context.getResources().getIdentifier(stickerNumber, "drawable", context.getPackageName());
        holder.getStickerImage().setImageResource(id);
    }

    @Override
    public int getItemCount() {
        return stickers.size();
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.recycler_view_item;
    }
}
