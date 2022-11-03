package com.example.group28assignmentapp.database;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.group28assignmentapp.R;
import com.example.group28assignmentapp.databinding.FragmentDatabaseLoginBinding;
import com.example.group28assignmentapp.databinding.LoginDialogBinding;


public class DatabaseLoginFragment extends Fragment {

    private DatabaseViewModel databaseViewModel;
    private FragmentDatabaseLoginBinding binding;



    public DatabaseLoginFragment() {
        // Required empty public constructor
    }

    public static DatabaseLoginFragment newInstance() {
        DatabaseLoginFragment fragment = new DatabaseLoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseViewModel = new ViewModelProvider(this).get(DatabaseViewModel.class);
        databaseViewModel.loadUsernames();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDatabaseLoginBinding.inflate(inflater, container, false);
        setCreateAccountClickListener();
        setEnterUsernameClickListener();
        return binding.getRoot();
    }

    /***********************************************************************************************
     * PRIVATE METHODS
     **********************************************************************************************/
    private void setCreateAccountClickListener() {
        binding.newUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                String username = inputUsername.getText().toString();
                                // TODO: Check username against list of Users in the DatabaseViewModel
                                // If there are no duplicates then create a new User



                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });
    }
    private void setEnterUsernameClickListener() {
        binding.enterUsernameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                String username = inputUsername.getText().toString();
                                // TODO: Check username against list of Users in the DatabaseViewModel
                                // If the username matches what we have in the ViewModel, then set the
                                // current user in the ViewModel and move to the next page.
                                databaseViewModel.setCurrentUser(username);
                                databaseViewModel.loadUsernames();



                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });
    }
}