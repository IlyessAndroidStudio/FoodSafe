package com.example.foodsafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;


import android.widget.TextView;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.budiyev.android.codescanner.ScanMode;
import com.example.foodsafe.databinding.ActivityMainBinding;
import com.google.zxing.Result;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private CodeScanner codeScanner;
    private TextView codeData;
    private CodeScannerView vueScanner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HistoriqueFragment());
        codeData = findViewById(R.id.text_code);
        vueScanner = findViewById(R.id.Vue_scanner);

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
                    runCodeScanner();
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

    private void runCodeScanner(){

        codeScanner = new CodeScanner(this, vueScanner);

        codeScanner.setAutoFocusEnabled(true);
        codeScanner.setFormats(CodeScanner.ALL_FORMATS);
        codeScanner.setScanMode(ScanMode.CONTINUOUS);

        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String data = result.getText();
                        codeData.setText(data);
                    }
                });
            }
        });


    }

}