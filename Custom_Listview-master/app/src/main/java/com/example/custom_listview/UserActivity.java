package com.example.custom_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.custom_listview.databinding.ActivityMainBinding;
import com.example.custom_listview.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {

    ActivityUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null){

            String nama = intent.getStringExtra("NamaMhs");
            String email = intent.getStringExtra("EmailMhs");
            String fakultas = intent.getStringExtra("FakultasMhs");
            String prodi = intent.getStringExtra("ProgramStudiMhs");
            String status = intent.getStringExtra("StatusMhs");
            String nim = intent.getStringExtra("NimMhs");
            String angkatan = intent.getStringExtra("AngkatanMhs");
            String semester = intent.getStringExtra("SemesterMhs");
            int imageId = intent.getIntExtra("imageidMhs",R.drawable.a);

            binding.namaMahasiswa.setText(nama);
            binding.emailMahasiswa.setText(email);
            binding.fakultasMahasiswa.setText(fakultas);
            binding.prodiMahasiswa.setText(prodi);
            binding.statusMahasiswa.setText(status);
            binding.nimMahasiswa.setText(nim);
            binding.angkatanMahasiswa.setText(angkatan);
            binding.semesterMahasiswa.setText(semester);
            binding.imageMahasiswa.setImageResource(imageId);
        }

    }
}