package com.example.group28assignmentapp.database;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.group28assignmentapp.R;
import com.example.group28assignmentapp.database.model.MessageViewModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.HttpCookie;
import java.util.ArrayList;

public class MessageViewActivity extends AppCompatActivity {
    private String username;
    private MessageViewModel sharedViewModel;
    private DatabaseReference mDatabase;
    boolean initialLoad = true;
    private ArrayList<Sticker> lastStickerList;
    private ArrayList<Sticker> stickerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createNotificationChannel();
        username = getIntent().getStringExtra("USERNAME");
        sharedViewModel = new ViewModelProvider(this).get(MessageViewModel.class);
        sharedViewModel.setUsername(username);
        setContentView(R.layout.activity_message_view);

        stickerList = new ArrayList<>();
        lastStickerList = new ArrayList<>();

        // Code to keep track of received sticker updates to send notifications
        mDatabase = FirebaseDatabase.getInstance().getReference("users3/" + username + "/received");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // We will be updating the UI to reflect the contents of stickerList, so need to
                // clear old entries if there are any:
                lastStickerList = (ArrayList<Sticker>) stickerList.clone();
                stickerList.clear();

                // If no stickers have been received, the snapshot value will be null
                if ((snapshot.getValue() == null)) {
                    return;
                }

                Sticker newSticker = new Sticker();
                // Every child of the snapshot is a Sticker. We want to add all these stickers to
                // our list of stickers
                for (DataSnapshot shot : snapshot.getChildren()) {
                    Sticker sticker = shot.getValue(Sticker.class);
                    if (!initialLoad && !lastStickerList.contains(sticker)) {
                        newSticker = sticker;
                    }
                    stickerList.add(sticker);
                }

                if (!initialLoad) {
                    // Don't send notifications on first read of database
                    notifyNewMessageReceived(newSticker);
                }

                if (initialLoad) {
                    initialLoad = false;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(getString(R.string.channel_id), name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to log out?").setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Need to override actionbar back button to call onBackPressed() so that we make sure that
        // users _really_ want to log out when they press back
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }

    // Method adapted from example code provided in class:
    public void notifyNewMessageReceived(Sticker sticker) {

        // Get Bitmap of sticker received so that we can display it in the notif:
        int id = this.getResources().getIdentifier(sticker.getSticker_number(),
                "drawable",
                this.getPackageName());
        Bitmap icon = BitmapFactory.decodeResource(this.getResources(),
                id);

        // Build notification:
        String channelID = getString(R.string.channel_id);
        Notification notif = new NotificationCompat.Builder(this, channelID)
                .setContentTitle("New Sticker!")
                .setContentText("Someone sent you a sticker - find out who!")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setLargeIcon(icon)
                .build();

        // Get the notification service from the system:
        NotificationManager notifManager = (NotificationManager) this
                .getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        notif.flags |= Notification.FLAG_AUTO_CANCEL;

        notifManager.notify(0, notif);
    }
}