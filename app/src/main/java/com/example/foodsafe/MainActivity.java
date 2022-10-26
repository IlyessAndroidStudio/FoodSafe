package com.example.foodsafe;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;



import android.widget.Button;

import com.example.foodsafe.databinding.ActivityMainBinding;
import com.google.zxing.client.android.Intents;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HistoriqueFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item ->{


            switch (item.getItemId()){

                case R.id.Favoris:
                    replaceFragment(new FavorisFragment());
                    break;
                case R.id.Historique:
                    replaceFragment(new HistoriqueFragment());
                    break;
                case R.id.Scan:
                    replaceFragment(new ScanFragment());
                    break;
            }



            return true;
        });

    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.FrameLayout,fragment);
        fragmentTransaction.commit();
    }


}