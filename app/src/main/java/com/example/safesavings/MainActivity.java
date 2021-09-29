package com.example.safesavings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.safesavings.fragment.FragmentAbout;
import com.example.safesavings.fragment.FragmentHome;
import com.example.safesavings.fragment.FragmentList;
import com.example.safesavings.fragment.FragmentSearch;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, new FragmentHome()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigation = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected( MenuItem item) {
            Fragment f =  null;
            switch (item.getItemId()){
                case R.id.menu_home:
                    f = new FragmentHome();
                    break;
                case R.id.menu_search:
                    f = new FragmentSearch();
                    break;
                case R.id.menu_list:
                    f = new FragmentList();
                    break;
                case R.id.menu_about:
                    f = new FragmentAbout();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,f).commit();
            return true;
        }
    };
}