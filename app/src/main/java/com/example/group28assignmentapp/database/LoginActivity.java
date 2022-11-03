package com.example.group28assignmentapp.database;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group28assignmentapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private DatabaseReference mUsers;
    private final String TAG = "REALTIME-DATABASE";

    @Override
    public void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        setContentView(R.layout.activity_login);

        // It's best to only reference data we need, as we don't want to listen to changes in the
        // whole database (which we would do if we called getReference without an arg and attached
        // a listener to that:
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Want app data to update in real time when the databse updates.
        // To do this, we add an event listener the the mUsers reference above:
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                Log.d(TAG, "Value is: " + map);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

}
