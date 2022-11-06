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
//        Context context = parent.getContext();
//        LayoutInflater inflater = LayoutInflater.from(context);
//
//        // Inflate the custom layout
//        View contactView = inflater.inflate(R.layout.item_contact, parent, false);
//
//        // Return a new holder instance
//        ViewHolder viewHolder = new ViewHolder(contactView);
//        return viewHolder;

        // Create a new view, which defines the UI of the list item
         View view = LayoutInflater.from(parent.getContext())
                 .inflate(R.layout.recyclerview_row, parent, false);
         return new RecyclerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.getAssociatedUser().setText(stickers.get(position).getAssociatedUser());

    }

    @Override
    public int getItemCount() {
        return stickers.size();
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.recyclerview_row;
    }
}
