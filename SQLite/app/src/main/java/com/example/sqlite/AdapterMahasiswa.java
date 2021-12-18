package com.example.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMahasiswa extends RecyclerView.Adapter<AdapterMahasiswa.ViewHolderMahasiswa>{
    private Context ctx;
    private ArrayList arrID, arrNama, arrEmail, arrFakultas, arrProdi, arrStatus, arrNim, arrAngkatan, arrSemester;

    public AdapterMahasiswa(Context ctx, ArrayList arrID, ArrayList arrNama, ArrayList arrEmail, ArrayList arrFakultas, ArrayList arrProdi, ArrayList arrStatus, ArrayList arrNim, ArrayList arrAngkatan, ArrayList arrSemester) {
        this.ctx = ctx;
        this.arrID = arrID;
        this.arrNama = arrNama;
        this.arrEmail = arrEmail;
        this.arrFakultas = arrFakultas;
        this.arrProdi = arrProdi;
        this.arrStatus = arrStatus;
        this.arrNim = arrNim;
        this.arrAngkatan = arrAngkatan;
        this.arrSemester = arrSemester;
    }

    @NonNull
    @Override
    public ViewHolderMahasiswa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater pompa = LayoutInflater.from(ctx);
        View view = pompa.inflate(R.layout.card_item, parent, false);
        return new ViewHolderMahasiswa(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMahasiswa holder, int position) {
        holder.tvId.setText(arrID.get(position).toString());
        holder.tvNama.setText(arrNama.get(position).toString());
        holder.tvNim.setText(arrNim.get(position).toString());
        holder.tvAngkatan.setText(arrAngkatan.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return arrID.size();
    }

    public class ViewHolderMahasiswa extends RecyclerView.ViewHolder{
        TextView tvId, tvNama, tvNim, tvAngkatan;

        public ViewHolderMahasiswa(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_id);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvNim = itemView.findViewById(R.id.tv_nim);
            tvAngkatan = itemView.findViewById(R.id.tv_angkatan);
        }
    }

}
