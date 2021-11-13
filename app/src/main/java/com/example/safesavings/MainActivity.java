package com.example.safesavings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.safesavings.fragment.FragmentAbout;
import com.example.safesavings.fragment.FragmentHome;
import com.example.safesavings.fragment.FragmentList;
import com.example.safesavings.fragment.FragmentSearch;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menampilkan halaman Fragment yang pertama kali muncul
        getFragmentPage(new FragmentHome());

        /*Inisialisasi BottomNavigationView beserta listenernya untuk
         *menangkap setiap kejadian saat salah satu menu item diklik
         */
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation_menu);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment f = null;

                //Menantukan halaman Fragment yang akan tampil
                switch (item.getItemId()){
                    case R.id.menu_home:
                        f = new FragmentHome();
                        if (getSupportActionBar()!=null){
                            getSupportActionBar().setTitle("Filme");
                        }
                        break;
                    case R.id.menu_search:
                        f = new FragmentSearch();
                        if (getSupportActionBar()!=null){
                            getSupportActionBar().setTitle("Pencarian");
                        }
                        break;
                    case R.id.menu_list:
                        f = new FragmentList();
                        if (getSupportActionBar()!=null){
                            getSupportActionBar().setTitle("Blog");
                        }
                        break;
                    case R.id.menu_about:
                        f = new FragmentAbout();
                        if (getSupportActionBar()!=null){
                            getSupportActionBar().setTitle("Tentang Kami");
                        }
                        break;
                }
                return getFragmentPage(f);
            }
        });
    }
    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_fragment, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    /*@Override
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
    };*/
}