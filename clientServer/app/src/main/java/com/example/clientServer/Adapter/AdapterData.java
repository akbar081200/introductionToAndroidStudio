package com.example.clientServer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clientServer.Model.DataModel;
import com.example.clientServer.R;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData>{

    private Context ctx;
    private List<DataModel> listMahasiswa;

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
        }
    }
}
