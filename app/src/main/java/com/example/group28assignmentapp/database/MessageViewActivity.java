package com.example.group28assignmentapp.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.group28assignmentapp.R;
import com.example.group28assignmentapp.databinding.ActivityMessageViewBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MessageViewActivity extends AppCompatActivity {
    private ActivityMessageViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_view);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.listContainerView);
        NavController navController = navHostFragment.getNavController();
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_database);
        bottomNav.setSelectedItemId(R.id.databaseSentListFragment);
        NavigationUI.setupWithNavController(bottomNav, navController);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration
                .Builder(R.id.databaseSentListFragment, R.id.databaseReceivedListFragment)
                .build();
        NavigationUI.setupActionBarWithNavController(this,
                navController,
                appBarConfiguration);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        NavController navController = Navigation.findNavController(this,
                R.id.listContainerView);
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}