package com.example.group28assignmentapp.web_service;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.example.group28assignmentapp.R;

import java.util.Timer;
import java.util.TimerTask;

public class LoadingDialog {
    private Activity activity;
    private AlertDialog dialog;
    private int counter = 0;
    private Timer timer;
    private TimerTask timerTask;

    LoadingDialog(Activity activity) {
        this.activity = activity;

        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                counter++;
                if (counter == 2) {
                    timer.cancel();
                    dialog.dismiss();
                }

            }
        };
    }

    public void startLoadingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.progress_dialog, null));
        builder.setCancelable(false);

        dialog = builder.create();
        dialog.show();
    }

    public void dismissDialog() {
        timer.schedule(timerTask, 100, 100);
    }
}
