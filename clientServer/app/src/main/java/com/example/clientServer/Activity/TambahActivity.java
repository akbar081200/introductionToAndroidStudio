package com.example.clientServer.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.clientServer.API.APIRequestData;
import com.example.clientServer.API.RetroServer;
import com.example.clientServer.Model.ResponseModel;
import com.example.clientServer.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahActivity extends AppCompatActivity {

    private EditText etNama, etEmail, etFakultas, etProdi, etStatus, etNim, etAngkatan, etSemester;
    private Button btnSimpan;
    private String nama, email, fakultas, prodi, status, nim, angkatan, semester;

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
                nama = etNama.getText().toString();
                email = etEmail.getText().toString();
                fakultas = etFakultas.getText().toString();
                prodi = etProdi.getText().toString();
                status = etStatus.getText().toString();
                nim = etNim.getText().toString();
                angkatan = etAngkatan.getText().toString();
                semester = etSemester.getText().toString();

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
                    createData();
                }
            }
        });
    }

    private void createData(){
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> simpanData = ardData.ardCreateData(nama, email, fakultas, prodi, status, nim, angkatan, semester);

        simpanData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(TambahActivity.this, "Kode : "+kode+" | Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(TambahActivity.this, "Gagal menghubungi server | "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}