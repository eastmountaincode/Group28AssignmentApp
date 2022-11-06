package com.example.group28assignmentapp.database.sendUI;

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

    public UserRecyclerAdapter(List<String> usernames) {
        this.usernames = usernames;
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

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView user;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            this.user = itemView.findViewById(R.id.associated_user_text);
        }

        public TextView getUser() {
            return user;
        }

        public void setUser(TextView user) {
            this.user = user;
        }
    }
}
