package com.example.appnghenhac;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.appnghenhac.fragment.HomeFragment;

public class NghenhacActivity extends AppCompatActivity {
    Button btBackC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nghenhac);
        btBackC= findViewById(R.id.btBack);
        btBackC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInf= getMenuInflater();
        menuInf.inflate(R.menu.optionmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.mnSearch:


                showActivity(item.getTitle().toString());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    void showActivity(String menu)
    {
        Intent i= new Intent(NghenhacActivity.this, HomeFragment.class);
        i.putExtra("menu",menu);
        startActivity(i);
    }
}