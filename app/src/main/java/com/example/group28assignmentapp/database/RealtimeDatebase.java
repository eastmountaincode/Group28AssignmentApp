package com.example.group28assignmentapp.database;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.group28assignmentapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;




public class RealtimeDatebase extends AppCompatActivity {
    private DatabaseReference dataBase;
    Button fireBase;
    TextView fireTest;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("hello world");
//        dataBase = FirebaseDatabase.getInstance().getReference();
//        fireBase = findViewById(R.id.button);
//        fireTest = findViewById(R.id.textViewFire);
//        fireBase.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                User user = new User("user1","doe");
//                dataBase.child("users").child(user.message).setValue("hello");
//            }
//        });



//        dataBase.child("users").addChildEventListener(
//                new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                User user = snapshot.getValue(User.class);
//                if (snapshot.getKey().equalsIgnoreCase("user1")){
//                    fireTest.setText("passed");
//                }
//                else{
//                    fireTest.setText("failed");
//                }
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//

    }

}
