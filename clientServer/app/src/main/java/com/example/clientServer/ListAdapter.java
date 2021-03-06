package com.example.clientServer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<User> {

    public ListAdapter(Context context, ArrayList<User> userArrayList){

        super(context,R.layout.list_item,userArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        User user = getItem(position);

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        TextView userName = convertView.findViewById(R.id.Name);
        TextView nim= convertView.findViewById(R.id.Nim);
        TextView angkatan= convertView.findViewById(R.id.Angkatan);

        userName.setText(user.nama);
        nim.setText(user.nim);
        angkatan.setText(user.angkatan);


        return convertView;
    }
}
