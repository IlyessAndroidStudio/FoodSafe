package com.example.foodsafe;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.Fragment;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;



import android.widget.Button;

import com.example.foodsafe.databinding.ActivityMainBinding;
import com.google.zxing.client.android.Intents;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    Button BtnScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}