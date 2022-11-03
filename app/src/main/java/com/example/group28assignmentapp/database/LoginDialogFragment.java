package com.example.group28assignmentapp.database;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.example.group28assignmentapp.R;

public class LoginDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedStateInstance) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = requireActivity().getLayoutInflater();


        dialog.setView(layoutInflater.inflate(R.layout.login_dialog, null))
                .setPositiveButton("Sign in", (dialogInterface, i) -> {
                    // Sign the user in
                })
                .setNegativeButton("Cancel", (dialogInterface, i) -> {
                    // Cancel
                    LoginDialogFragment.this.getDialog().cancel();
                });
        return dialog.create();
    }
}
