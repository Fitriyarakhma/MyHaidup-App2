package com.project.trackerapp;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private ActionBar actionBar;
    public Toolbar toolbar;
    private Menu menu_navigation;
    private DrawerLayout drawer;
    HomeFragment homeFragment;
    public TextView titleTextView;

    public void setToolbar(String teks) {
        this.titleTextView.setText(teks);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String param = getIntent().getStringExtra("redirect");

        homeFragment = new HomeFragment();

        initToolbar();
        initNavigationMenu();

        titleTextView = toolbar.findViewById(R.id.toolbar_title);
        titleTextView.setVisibility(View.GONE);

        if(param != null){
            titleTextView.setVisibility(View.GONE);
            switch (param) {
                case "home":
                    actionBar.setTitle("Home");
                    replaceFragment(homeFragment);
                    break;
                default:
                    actionBar.setTitle("");
                    titleTextView.setVisibility(View.VISIBLE);
                    replaceFragment(homeFragment);
                    break;
            }
        }else {
            actionBar.setTitle("");
            titleTextView.setVisibility(View.VISIBLE);
            replaceFragment(homeFragment);
        }
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("");
        setSystemBarColor(this, R.color.colorPrimary);
    }
    private void initNavigationMenu() {
        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        nav_view.inflateMenu(R.menu.menu_navigation_drawer);

        View header = nav_view.getHeaderView(0);
        TextView tvUsername = header.findViewById(R.id.tv_username);
        ImageView logo = header.findViewById(R.id.imgv_logo);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open_navigation_drawer, R.string.close_navigation_drawer) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(final MenuItem item) {
                onItemNavigationClicked(item);
                return true;
            }
        });


        // open drawer at start
        //drawer.openDrawer(GravityCompat.START);
        //menu_navigation = nav_view.getMenu();
    }

    private void onItemNavigationClicked(MenuItem item) {
        actionBar.setTitle(item.getTitle());
        if (item.getItemId() == R.id.nav_home) {
            actionBar.setTitle("");
            titleTextView.setVisibility(View.VISIBLE);
            replaceFragment(homeFragment);
        }
        drawer.closeDrawers();
    }

    public static void setSystemBarColor(Activity act, @ColorRes int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = act.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(act.getResources().getColor(color));
        }
    }

    private void replaceFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

}