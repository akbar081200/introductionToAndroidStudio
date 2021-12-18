package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMahasiswa;
    MyDatabaseHelper myDB;
    AdapterMahasiswa adapterMahasiswa;
    ArrayList<String> arrID, arrNama, arrEmail, arrFakultas, arrProdi, arrStatus, arrNim, arrAngkatan, arrSemester;
//    public static int posisiData = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new MyDatabaseHelper(MainActivity.this);
        arrID = new ArrayList<>();
        arrNama = new ArrayList<>();
        arrNim = new ArrayList<>();
        arrAngkatan = new ArrayList<>();

        SQLitetoArraylist();

        rvMahasiswa = findViewById(R.id.rv_mahasiswa);
//        menyiapkan
        adapterMahasiswa = new AdapterMahasiswa(MainActivity.this, arrID, arrNama,arrEmail, arrFakultas, arrProdi, arrStatus, arrNim, arrAngkatan, arrSemester);
//        melakukan
        rvMahasiswa.setAdapter(adapterMahasiswa);
        rvMahasiswa.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }

    public void bukaActivityTambah(View view) {
        startActivity(new Intent(MainActivity.this, TambahActivity.class));
    }

    private void SQLitetoArraylist(){
        Cursor cursor = myDB.bacaSemuaData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "Tidak ada data", Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                arrID.add(cursor.getString(0));
                arrNama.add(cursor.getString(1));
                arrNim.add(cursor.getString(6));
                arrAngkatan.add(cursor.getString(7));
            }
        }
    }
}