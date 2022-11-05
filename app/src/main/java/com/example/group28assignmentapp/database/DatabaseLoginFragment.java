package com.example.group28assignmentapp.database;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.group28assignmentapp.R;
import com.example.group28assignmentapp.databinding.FragmentDatabaseLoginBinding;


public class DatabaseLoginFragment extends Fragment {

    private DatabaseViewModel databaseViewModel;
    private FragmentDatabaseLoginBinding binding;



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
        databaseViewModel = new ViewModelProvider(this).get(DatabaseViewModel.class);
        databaseViewModel.listenToDatabase();
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
                        if (!databaseViewModel.userExists(username)) {
                            // Create a new user if no duplicates
                            databaseViewModel.createUser(username);
                            // TODO: Go to logged in view!
                            Intent myIntent = new Intent(getActivity(), MessageViewActivity.class);
                            getActivity().startActivity(myIntent);
                            //Navigation.findNavController(view).navigate(R.id.loginToMessageView);

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
                        if (databaseViewModel.userExists(username)) {
                            databaseViewModel.setCurrentUser(username);
                            // TODO: Go to next screen
                            Intent myIntent = new Intent(getActivity(), MessageViewActivity.class);
                            getActivity().startActivity(myIntent);
                            //Navigation.findNavController(v).navigate(R.id.loginToMessageView);

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