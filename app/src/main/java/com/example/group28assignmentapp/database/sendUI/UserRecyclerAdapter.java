package com.example.group28assignmentapp.database.sendUI;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group28assignmentapp.R;

import java.util.List;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.UserViewHolder> {
    List<String> usernames;
    String currentUser;
    private RecyclerViewClickListener listener;


    public UserRecyclerAdapter(List<String> usernames, String currentUser, RecyclerViewClickListener listener) {
        this.usernames = usernames;
        this.currentUser = currentUser;
        this.listener = listener;
    }

    @NonNull
    @Override
    public UserRecyclerAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserRecyclerAdapter.UserViewHolder holder, int position) {
        holder.getUser().setText(usernames.get(position));


    }

    @Override
    public int getItemCount() {
        return usernames.size();
    }


    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView user;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            this.user = itemView.findViewById(R.id.associated_user_text);
            itemView.setOnClickListener(this);
        }

        public TextView getUser() {
            return user;
        }

        public void setUser(TextView user) {
            this.user = user;
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());

        }
    }
}
