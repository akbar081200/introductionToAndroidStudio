package com.example.clientServer;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.clientServer.databinding.FragmentAngkatan2019Binding;

import java.util.ArrayList;


public class Angkatan2019 extends Fragment {

    FragmentAngkatan2019Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAngkatan2019Binding.inflate(inflater, container, false);

        int[] imageId = {
                R.drawable.a19,
                R.drawable.b19,
                R.drawable.c19,
                R.drawable.d19,
                R.drawable.e19,
                R.drawable.f19,
                R.drawable.g19,
                R.drawable.h19,
                R.drawable.i19,
                R.drawable.j19};

        String[] nama = {
                "Dwiki Affandi",
                "Arafah Nur Ihza",
                "Jefry Lianto",
                "Nanda Ambiya",
                "Chrismario Linear",
                "Willioms Sanjaya",
                "Jason Surya Faylim",
                "Hendry Winata",
                "Felipe",
                "Christina"};
        String[] email = {
                "dwikiaffandi7974@gmail.com",
                "imnuzul.setiawan@gmail.com",
                "liantojefry@gmail.com",
                "nandaambiya05@gmail.com",
                "mariolinear97@gmail.com",
                "williomssanjaya@gmail.com",
                "jasonsuryaf@gmail.com",
                "hendry24680@gmail.com",
                "felipelie97@gmail.com",
                "christina.tkn@gmail.com"};
        String[] fakultas = {
                "Fasilkom-TI",
                "Fasilkom-TI",
                "Fasilkom-TI",
                "Fasilkom-TI",
                "Fasilkom-TI",
                "Fasilkom-TI",
                "Fasilkom-TI",
                "Fasilkom-TI",
                "Fasilkom-TI",
                "Fasilkom-TI"};
        String[] prodi = {
                "Teknologi Informasi",
                "Teknologi Informasi",
                "Teknologi Informasi",
                "Teknologi Informasi",
                "Teknologi Informasi",
                "Teknologi Informasi",
                "Teknologi Informasi",
                "Teknologi Informasi",
                "Teknologi Informasi",
                "Teknologi Informasi"};
        String[] status = {
                "Aktif",
                "Aktif",
                "Aktif",
                "Aktif",
                "Aktif",
                "Aktif",
                "Aktif",
                "Aktif",
                "Aktif",
                "Aktif"};
        String[] nim = {
                "191402011",
                "191402012",
                "191402027",
                "191402039",
                "191402058",
                "191402060",
                "191402062",
                "191402072",
                "191402086",
                "191402089"};
        String[] angkatan = {
                "2019",
                "2019",
                "2019",
                "2019",
                "2019",
                "2019",
                "2019",
                "2019",
                "2019",
                "2019"};
        String[] semester = {
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            User user = new User(nama[i],email[i],fakultas[i],prodi[i],status[i],imageId[i],nim[i],angkatan[i],semester[i]);
            userArrayList.add(user);

        }

        ListAdapter listAdapter = new ListAdapter(getActivity(),userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(),UserActivity.class);
                i.putExtra("NamaMhs",nama[position]);
                i.putExtra("NimMhs",nim[position]);
                i.putExtra("EmailMhs",email[position]);
                i.putExtra("AngkatanMhs",angkatan[position]);
                i.putExtra("FakultasMhs",fakultas[position]);
                i.putExtra("ProgramStudiMhs",prodi[position]);
                i.putExtra("SemesterMhs",semester[position]);
                i.putExtra("StatusMhs",status[position]);
                i.putExtra("imageidMhs",imageId[position]);
                startActivity(i);
            }
        });

        return binding.getRoot();
    }
}