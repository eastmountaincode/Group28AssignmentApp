package com.example.group28assignmentapp.database;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.group28assignmentapp.databinding.FragmentDatabaseLoginBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashSet;
import java.util.Set;


public class DatabaseLoginFragment extends Fragment {
    private final Set<String> listOfUsernames = new HashSet<>();
    private FragmentDatabaseLoginBinding binding;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users3");
    private final String TAG = "REALTIME-DATABASE";



    public DatabaseLoginFragment() {
        // Required empty public constructor
    }

    public static DatabaseLoginFragment newInstance() {
        // TODO: what is this for?
        DatabaseLoginFragment fragment = new DatabaseLoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listenToDatabase();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDatabaseLoginBinding.inflate(inflater, container, false);
        setCreateAccountClickListener();
        setEnterUsernameClickListener();
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void listenToDatabase() {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // loop all the data
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    listOfUsernames.add(snapshot.getKey());  // For speedy lookup
                }
                Log.d(TAG, listOfUsernames.toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }


    /***********************************************************************************************
     * PRIVATE METHODS
     **********************************************************************************************/
    private void setCreateAccountClickListener() {
        binding.newUserButton.setOnClickListener(view -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
            builder1.setMessage("New user.\nEnter your proposed username.");
            // Set up the input
            final EditText inputUsername = new EditText(getContext());
            // Specify the type of input expected
            inputUsername.setInputType(InputType.TYPE_CLASS_TEXT);
            builder1.setView(inputUsername);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Login",
                    (dialog, id) -> {
                        String username = inputUsername.getText().toString();
                        if (!listOfUsernames.contains(username)) {
                            // Create a new user if no duplicates
                            User newUser = new User(username);
                            mDatabase.child(username).setValue(newUser);
                            // Go to logged in view!
                            Intent myIntent = new Intent(getActivity(), MessageViewActivity.class);
                            myIntent.putExtra("USERNAME", username);
                            myIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            getActivity().startActivity(myIntent);

                        } else {
                            Toast.makeText(getContext(), "Username already exists", Toast.LENGTH_SHORT).show();
                        }
                        dialog.cancel();
                    });

            builder1.setNegativeButton(
                    "Cancel",
                    (dialog, id) -> dialog.cancel());

            AlertDialog alert11 = builder1.create();
            alert11.show();
        });
    }

    private void setEnterUsernameClickListener() {
        binding.enterUsernameButton.setOnClickListener(v -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
            builder1.setMessage("Returning user.\nEnter your username.");
            // Set up the input
            final EditText inputUsername = new EditText(getContext());
            // Specify the type of input expected
            inputUsername.setInputType(InputType.TYPE_CLASS_TEXT);
            builder1.setView(inputUsername);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Login",
                    (dialog, id) -> {
                        String username = inputUsername.getText().toString();
                        // If the username matches what we have in the ViewModel, then set the
                        // current user in the ViewModel and move to the next page.
                        if (listOfUsernames.contains(username)) {
                            // Check if user exists and set current user
                            Intent myIntent = new Intent(getActivity(), MessageViewActivity.class);
                            myIntent.putExtra("USERNAME", username);
                            myIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            getActivity().startActivity(myIntent);

                        } else {
                            Toast.makeText(getContext(), "Username not found", Toast.LENGTH_SHORT).show();
                        }
                    });

            builder1.setNegativeButton(
                    "Cancel",
                    (dialog, id) -> dialog.cancel());

            AlertDialog alert11 = builder1.create();
            alert11.show();
        });
    }
}