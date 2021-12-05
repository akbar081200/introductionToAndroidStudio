package com.example.clientServer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import com.example.clientServer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Spinner spinner;
    Angkatan2018 angkatan2018;
    Angkatan2019 angkatan2019;
    Angkatan2017 angkatan2017;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        spinner = findViewById(R.id.angkatan_spinner);

        angkatan2017 = new Angkatan2017();
        angkatan2018 = new Angkatan2018();
        angkatan2019 = new Angkatan2019();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                R.layout.custom_spinner,
                getResources().getStringArray(R.array.angkatan_spinner));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        setFragment(angkatan2017);
                        break;
                    case 1:
                        setFragment(angkatan2018);
                        break;
                    case 2:
                        setFragment(angkatan2019);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();
    }
}
