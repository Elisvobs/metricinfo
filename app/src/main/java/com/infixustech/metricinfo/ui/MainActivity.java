package com.infixustech.metricinfo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.infixustech.metricinfo.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public static final String SHARE_DESCRIPTION = "Download the metric fragment_info app to assist you in metric & imperial conversions on ";
    public static final String metricUrl = "https://play.google.com/store/apps/details?id=";
    BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_tables, R.id.navigation_info)
                .build();

        NavController navController = Navigation.findNavController(
                this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(
                this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_share) {
            Intent shareIntent = new Intent();
            String shareText = SHARE_DESCRIPTION + metricUrl;
            shareIntent.setAction(Intent.ACTION_SEND).setType("text/plain")
                    .putExtra(Intent.EXTRA_SUBJECT, "Metric Converter")
                    .putExtra(Intent.EXTRA_TEXT, shareText);
            startActivity(shareIntent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

}