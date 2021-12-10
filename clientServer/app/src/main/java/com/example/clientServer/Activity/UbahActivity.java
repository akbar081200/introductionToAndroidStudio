package com.example.clientServer.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class UbahActivity extends AppCompatActivity {

    private int xId, xImageID;
    private String xNama, xEmail, xFakultas, xProdi, xStatus, xNim, xAngkatan, xSemester;
    private EditText etNama, etEmail, etFakultas, etProdi, etStatus, etNim, etAngkatan, etSemester;
    private Button btnUbah;
    private String yNama, yEmail, yFakultas, yProdi, yStatus, yNim, yAngkatan, ySemester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah);

        Intent terima = getIntent();
        xId = terima.getIntExtra("xId",-1);
        xImageID = terima.getIntExtra("xImageID",-1);
        xNama = terima.getStringExtra("xNama");
        xEmail = terima.getStringExtra("xEmail");
        xFakultas = terima.getStringExtra("xFakultas");
        xProdi = terima.getStringExtra("xProdi");
        xStatus = terima.getStringExtra("xStatus");
        xNim = terima.getStringExtra("xNim");
        xAngkatan = terima.getStringExtra("xAngkatan");
        xSemester = terima.getStringExtra("xSemester");

        etNama = findViewById(R.id.et_nama);
        etEmail = findViewById(R.id.et_email);
        etFakultas = findViewById(R.id.et_fakultas);
        etProdi = findViewById(R.id.et_prodi);
        etStatus = findViewById(R.id.et_status);
        etNim = findViewById(R.id.et_nim);
        etAngkatan = findViewById(R.id.et_angkatan);
        etSemester = findViewById(R.id.et_semester);
        btnUbah = findViewById(R.id.btn_ubah);

        etNama.setText(xNama);
        etEmail.setText(xEmail);
        etFakultas.setText(xFakultas);
        etProdi.setText(xProdi);
        etStatus.setText(xStatus);
        etNim.setText(xNim);
        etAngkatan.setText(xAngkatan);
        etSemester.setText(xSemester);

        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                yNama = etNama.getText().toString();
                yEmail = etEmail.getText().toString();
                yFakultas = etFakultas.getText().toString();
                yProdi = etProdi.getText().toString();
                yStatus = etStatus.getText().toString();
                yNim = etNim.getText().toString();
                yAngkatan = etAngkatan.getText().toString();
                ySemester = etSemester.getText().toString();
                updateData();
            }
        });

    }

    private void updateData(){
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> ubahData = ardData.ardUpdateData(xId,yNama, yEmail, yFakultas, yProdi, yStatus, yNim, yAngkatan, ySemester);

        ubahData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(UbahActivity.this, "Kode : "+kode+" | Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(UbahActivity.this, "Gagal menghubungi server | "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}