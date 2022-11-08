package com.example.group28assignmentapp.database.customrecycler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group28assignmentapp.R;
import com.example.group28assignmentapp.database.Sticker;

import java.util.ArrayList;
import java.util.Arrays;

public class DatabaseRecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    ArrayList<Sticker> stickers;
    private final static String TAG = "REALTIME-DATABASE-ADAPTER";
    private Context context;
    private ArrayList<String> stickerStringList = new ArrayList<>(Arrays.asList("pavlu", "clark", "feinberg", "park"));

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
        // Handle case where stickerNumber, the name of the sticker, is not known to us possibly
        // because someone is using a different version of the app
        int id;
        if (stickerStringList.contains(stickerNumber)) {
            id = context.getResources().getIdentifier(stickerNumber, "drawable", context.getPackageName());
        }
        else {
            id = context.getResources().getIdentifier("error", "drawable", context.getPackageName());
        }
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
