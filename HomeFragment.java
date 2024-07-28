package com.project.trackerapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFragment extends Fragment {
    BottomNavigationView btmNav;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        btmNav = root.findViewById(R.id.navigation);
        btmNav.getMenu().getItem(0).setIcon(R.drawable.ic_home);

        HomeDashboardFragment homeDashboardFragment = new HomeDashboardFragment();
        HomeCaseworkerFragment homeCaseworkerFragment = new HomeCaseworkerFragment();
        HomeTrackerFragment homeTrackerFragment = new HomeTrackerFragment();

        replaceFragment(homeDashboardFragment);

        btmNav.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.menu_setting:
                            replaceFragment(homeCaseworkerFragment);
                            break;
                        case R.id.menu_tracker:
                            replaceFragment(homeTrackerFragment);
                            break;
                        default:
                            replaceFragment(homeDashboardFragment);
                            break;
                    }
                    return true;
                });

        return root;
    }

    private void replaceFragment(Fragment fragment) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_sub, fragment)
                .commit();
    }


}