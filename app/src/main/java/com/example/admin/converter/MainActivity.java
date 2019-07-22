package com.example.admin.converter;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent it = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(it);
                finish();

            }
        }, 2000);
    }



    }

