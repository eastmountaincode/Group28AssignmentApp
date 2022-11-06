package com.example.group28assignmentapp.database;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.group28assignmentapp.R;
import com.example.group28assignmentapp.databinding.ActivityMessageViewBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MessageViewActivity extends AppCompatActivity {
    private ActivityMessageViewBinding binding;
    BottomNavigationView bottomNavigationView;
    DatabaseLoginFragment databaseLoginFragment;
    DatabaseReceivedListFragment databaseReceivedListFragment;
    DatabaseSentListFragment databaseSentListFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessageViewBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_message_view);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_database);
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.databaseSentListFragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.listContainerView, new DatabaseSentListFragment()).commit();
                        return true;
                    case R.id.databaseReceivedListFragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.listContainerView, new DatabaseReceivedListFragment()).commit();
                        return true;
                }
                return false;
            }
        });








//        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.listContainerView);




//                bottomNav.setSelectedItemId(R.id.databaseSentListFragment);
//
//        NavigationUI.setupWithNavController(bottomNav, navController);
//
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration
//                .Builder(R.id.databaseSentListFragment, R.id.databaseReceivedListFragment)
//                .build();
//        NavigationUI.setupActionBarWithNavController(this,
//                navController,
//                appBarConfiguration);
//        navController.navigate(R.id.databaseSentListFragment);


    }




//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        NavController navController = Navigation.findNavController(this,
//                R.id.listContainerView);
//        return NavigationUI.onNavDestinationSelected(item, navController)
//                || super.onOptionsItemSelected(item);
//    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}