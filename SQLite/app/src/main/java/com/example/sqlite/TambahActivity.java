package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahActivity extends AppCompatActivity {
    private EditText etNama, etEmail, etFakultas, etProdi, etStatus, etNim, etAngkatan, etSemester;
    private Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNama = findViewById(R.id.et_nama);
        etEmail = findViewById(R.id.et_email);
        etFakultas = findViewById(R.id.et_fakultas);
        etProdi = findViewById(R.id.et_prodi);
        etStatus = findViewById(R.id.et_status);
        etNim = findViewById(R.id.et_nim);
        etAngkatan = findViewById(R.id.et_angkatan);
        etSemester = findViewById(R.id.et_semester);
        btnSimpan = findViewById(R.id.btn_simpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = etNama.getText().toString();
                String email = etEmail.getText().toString();
                String fakultas = etFakultas.getText().toString();
                String prodi = etProdi.getText().toString();
                String status = etStatus.getText().toString();
                String nim = etNim.getText().toString();
                String angkatan = etAngkatan.getText().toString();
                String semester = etSemester.getText().toString();

                if(nama.trim().equals("")){
                    etNama.setError("Nama Harus Diisi");
                }
                else if(email.trim().equals("")){
                    etEmail.setError("Nama Harus Diisi");
                }
                else if(fakultas.trim().equals("")){
                    etFakultas.setError("Nama Harus Diisi");
                }
                else if(prodi.trim().equals("")){
                    etProdi.setError("Nama Harus Diisi");
                }
                else if(status.trim().equals("")){
                    etStatus.setError("Nama Harus Diisi");
                }
                else if(nim.trim().equals("")){
                    etNim.setError("Nama Harus Diisi");
                }
                else if(angkatan.trim().equals("")){
                    etAngkatan.setError("Nama Harus Diisi");
                }
                else if(semester.trim().equals("")){
                    etSemester.setError("Nama Harus Diisi");
                }
                else{
                    MyDatabaseHelper myDB = new MyDatabaseHelper(TambahActivity.this);
                    long eksekusi = myDB.tambahMahasiswa(nama,email,fakultas,prodi,status,nim,angkatan,semester);

                    if(eksekusi == -1){
                        Toast.makeText(TambahActivity.this, "Gagal Menambah Data !", Toast.LENGTH_SHORT).show();
                        etNama.requestFocus();
                    }
                    else{
                        Toast.makeText(TambahActivity.this, "Tambah Data Berhasil", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(TambahActivity.this, MainActivity.class));
                        finish();
                    }
                }
            }
        });

    }
}