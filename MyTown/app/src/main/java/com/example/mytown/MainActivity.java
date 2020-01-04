package com.example.mytown;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    int images[] = {R.drawable.ghh2,R.drawable.primaria_gh,R.drawable.ghh, R.drawable.ghh4, R.drawable.ghh3, R.drawable.ghh5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Fragment homeFragment = new HomeFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_place, homeFragment, "first");
        ft.addToBackStack(String.valueOf(homeFragment));
        ft.commit();*/

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitleTextAppearance(this, R.style.AppTheme_NoActionBar_Title);


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView= findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if( savedInstanceState == null) {
            Fragment homeFragment= new HomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_place, new HomeFragment(), "first").addToBackStack(String.valueOf(homeFragment)).commit();
            navigationView.setCheckedItem(R.id.nav_info);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_objectives:
                Fragment objFragment= new ObjectivesFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place, new ObjectivesFragment(), "second").addToBackStack(String.valueOf(objFragment)).commit();
                break;
            case R.id.nav_info:
                HomeFragment homeFragment= new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place, new HomeFragment(), "first").addToBackStack(String.valueOf(homeFragment)).commit();
                break;
            case R.id.nav_atractii:
                Fragment atractiiFragment= new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place, new AtractiiFragment(), "first").addToBackStack(String.valueOf(atractiiFragment)).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
