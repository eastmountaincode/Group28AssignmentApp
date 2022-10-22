package com.example.group28assignmentapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    Context context;
    List<Entry> listOfTopSongs;
    public RecyclerAdapter(Context context, List<Entry> listOfTopSongs) {
        this.context = context;
        this.listOfTopSongs = listOfTopSongs;
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_row, parent,false);

        return new RecyclerAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        holder.artist.setText(listOfTopSongs.get(position).getArtistName());
        holder.name.setText(listOfTopSongs.get(position).getSongTitle());
        holder.rank.setText(listOfTopSongs.get(position).getRank());
    }

    @Override
    public int getItemCount() {
        return listOfTopSongs.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView artist, name, rank;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            artist.findViewById(R.id.textViewArtist);
            name.findViewById(R.id.textViewName);
            rank.findViewById(R.id.textViewRank);

        }
    }
}
