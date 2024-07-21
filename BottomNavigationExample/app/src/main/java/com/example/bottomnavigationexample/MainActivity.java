package com.example.bottomnavigationexample;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        bnView = findViewById(R.id.btView);
        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                if(id==R.id.nav_home){
                    loadFragment(new AFragment(), false);
                } else if (id==R.id.nav_search){
                    loadFragment(new BFragment(), false);
                } else if (id==R.id.nav_utilities){
                    loadFragment(new CFragment(),false);

                } else if (id==R.id.nav_contact){
                    loadFragment(new DFragment(),false);

                } else {
                    loadFragment(new EFragment(), true);

                }
                return true;
            }
        });

        bnView.setSelectedItemId(R.id.nav_profile);
    }

    public void loadFragment(Fragment fragment, boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag){
            ft.add(R.id.container,fragment);
        }else {
            ft.replace(R.id.container,fragment);
        }

        ft.commit();
    }
}