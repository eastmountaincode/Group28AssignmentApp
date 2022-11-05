package com.example.group28assignmentapp.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.group28assignmentapp.R;
import com.example.group28assignmentapp.databinding.ActivityMessageViewBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Map;

public class MessageViewActivity extends AppCompatActivity {
    private ActivityMessageViewBinding binding;
    private DatabaseViewModel viewModel;
    private static final String TAG = "REALTIME-DATABASE";

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
        navController.navigate(R.id.databaseSentListFragment);

        viewModel = new ViewModelProvider(this).get(DatabaseViewModel.class);

        final Observer<Map<String, User>> userObserver = new Observer<Map<String, User>>() {
            @Override
            public void onChanged(Map<String, User> stringObjectMap) {
                viewModel.setCurrentUser(viewModel.getCurrentUsername());
                Log.d(TAG, viewModel.getCurrentUser().toString());
            }
        };

        viewModel.getUsers().observe(navHostFragment.getViewLifecycleOwner(), userObserver);


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