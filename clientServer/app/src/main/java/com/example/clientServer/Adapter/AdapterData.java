package com.example.clientServer.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clientServer.API.APIRequestData;
import com.example.clientServer.API.RetroServer;
import com.example.clientServer.Activity.MainActivity;
import com.example.clientServer.Activity.UbahActivity;
import com.example.clientServer.Model.DataModel;
import com.example.clientServer.Model.ResponseModel;
import com.example.clientServer.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData>{

    private Context ctx;
    private List<DataModel> listMahasiswa;
    private List<DataModel> listIndividu;
    private int idMhs;

    public AdapterData(Context ctx, List<DataModel> listMahasiswa) {
        this.ctx = ctx;
        this.listMahasiswa = listMahasiswa;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = listMahasiswa.get(position);

        holder.tvId.setText(String.valueOf(dm.getId_mhs()));
        holder.tvNama.setText(dm.getNama());
        holder.tvNim.setText(dm.getNim());
        holder.tvAngkatan.setText(dm.getAngkatan());
    }

    @Override
    public int getItemCount() {
        return listMahasiswa.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvId, tvNama, tvNim, tvAngkatan;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_id);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvNim = itemView.findViewById(R.id.tv_nim);
            tvAngkatan = itemView.findViewById(R.id.tv_angkatan);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    AlertDialog.Builder dialogPesan = new AlertDialog.Builder(ctx);
                    dialogPesan.setMessage("Pilih Operasi yang Ingin Dilakukan");
                    dialogPesan.setTitle("Perhatian");
                    dialogPesan.setIcon(R.mipmap.ic_launcher_round);
                    dialogPesan.setCancelable(true);

                    idMhs = Integer.parseInt(tvId.getText().toString());

                    dialogPesan.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            deleteData();
                            dialogInterface.dismiss();
                            ((MainActivity) ctx).retrieveData();
                        }
                    });

                    dialogPesan.setNegativeButton("Ubah", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            getData();
                            dialogInterface.dismiss();
                        }
                    });

                    dialogPesan.show();

                    return false;
                }
            });

        }

        private void deleteData(){
            APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
            Call<ResponseModel> hapusData = ardData.ardDeleteData(idMhs);

            hapusData.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    int kode = response.body().getKode();
                    String pesan = response.body().getPesan();

                    Toast.makeText(ctx, "Kode : "+kode+" | Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    Toast.makeText(ctx, "Gagal Menghubungi Server : "+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        private void getData(){
            APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
            Call<ResponseModel> ambilData = ardData.ardGetData(idMhs);

            ambilData.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    int kode = response.body().getKode();
                    String pesan = response.body().getPesan();
                    listIndividu = response.body().getData();

                    int varIdIndividu = listIndividu.get(0).getId_mhs();
                    int varImageID = listIndividu.get(0).getImageID();
                    String varNamaIndividu = listIndividu.get(0).getNama();
                    String varEmailIndividu = listIndividu.get(0).getEmail();
                    String varFakultasIndividu = listIndividu.get(0).getFakultas();
                    String varProdiIndividu = listIndividu.get(0).getProdi();
                    String varStatusIndividu = listIndividu.get(0).getStatus();
                    String varNimIndividu = listIndividu.get(0).getNim();
                    String varAngkatanIndividu = listIndividu.get(0).getAngkatan();
                    String varSemesterIndividu = listIndividu.get(0).getSemester();

//                    Toast.makeText(ctx, "Kode : "+kode+" | Pesan : "+pesan+varAngkatanIndividu+varEmailIndividu, Toast.LENGTH_SHORT).show();

                    Intent kirim = new Intent(ctx, UbahActivity.class);
                    kirim.putExtra("xId", varIdIndividu);
                    kirim.putExtra("xNama", varNamaIndividu);
                    kirim.putExtra("xEmail", varEmailIndividu);
                    kirim.putExtra("xFakultas", varFakultasIndividu);
                    kirim.putExtra("xProdi", varProdiIndividu);
                    kirim.putExtra("xStatus", varStatusIndividu);
                    kirim.putExtra("xNim", varNimIndividu);
                    kirim.putExtra("xAngkatan", varAngkatanIndividu);
                    kirim.putExtra("xSemester", varSemesterIndividu);
                    kirim.putExtra("xImageID", varImageID);
                    ctx.startActivity(kirim);
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    Toast.makeText(ctx, "Gagal Menghubungi Server : "+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
