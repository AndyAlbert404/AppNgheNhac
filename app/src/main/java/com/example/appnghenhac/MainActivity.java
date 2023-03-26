package com.example.appnghenhac;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import com.example.appnghenhac.LG_and_RG.LoginActivity;
import com.example.appnghenhac.fragment.HomeFragment;
import com.example.appnghenhac.fragment.LibraryFragment;
import com.example.appnghenhac.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    Button btPlay1A, btPlay2A, btPlay3A;
BottomNavigationView fragOption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ fragment
        fragOption= findViewById(R.id.navMenu);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setTitle("Main");
        actionBar.setDisplayHomeAsUpEnabled(true);
        fragOption.setOnItemSelectedListener(getListener());
    }

//nút option của menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInf= getMenuInflater();
        menuInf.inflate(R.menu.optionmenu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnAcc:
                showActivity(item.getTitle().toString());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    void showActivity(String menu)
    {
        Intent i= new Intent(MainActivity.this, LoginActivity.class);
        i.putExtra("menu",menu);
        startActivity(i);
    }

//nút option của fragment
    @NonNull
    private NavigationBarView.OnItemSelectedListener getListener() {
        return new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mnHome:
                        loadFragment(new HomeFragment());
                        return true;
                    case R.id.mnSearch:
                        loadFragment(new SearchFragment());
                        return true;
                    case R.id.mnLib:
                        loadFragment(new LibraryFragment());
                        return true;
                }
                return true;
            }
        };
    }
    void loadFragment(Fragment fmNew){
        FragmentTransaction fmTran= getSupportFragmentManager().beginTransaction();
        fmTran.replace(R.id.main_fragment, fmNew);
        fmTran.addToBackStack(null);
        fmTran.commit();
    }
}