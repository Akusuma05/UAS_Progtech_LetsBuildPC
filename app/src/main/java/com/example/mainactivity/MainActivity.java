package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import model.casepcsimpen;
import model.cpucoolersimpen;
import model.cpusimpen;
import model.gpusimpen;
import model.memorysimpen;
import model.motherboardsimpen;
import model.psusimpen;
import model.storagesimpen;
import model.user;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghilangkan Action Bar
        getSupportActionBar().hide();

        //Untuk Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this, R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        cpusimpen.cpusimpen = "";
        cpucoolersimpen.cpucoolersimpen = "";
        motherboardsimpen.motherboardsimpen = "";
        memorysimpen.memorysimpen = 0;
        storagesimpen.storagesimpen = 0;
        gpusimpen.gpusimpen = "";
        casepcsimpen.casepcsimpen = "";
        psusimpen.psusimpen = "";
    }
}