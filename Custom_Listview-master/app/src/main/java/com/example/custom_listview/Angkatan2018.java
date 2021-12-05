package com.example.custom_listview;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.custom_listview.databinding.FragmentAngkatan2017Binding;
import com.example.custom_listview.databinding.FragmentAngkatan2018Binding;

import java.util.ArrayList;

public class Angkatan2018 extends Fragment {

    FragmentAngkatan2018Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAngkatan2018Binding.inflate(inflater, container, false);

        int[] imageId = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d,
                R.drawable.e, R.drawable.f,R.drawable.g, R.drawable.h,R.drawable.i, R.drawable.j};

        String[] nama = {
                "Zhafar Salim",
                "Muhammad Ridho",
                "Ammar Rafi Afandi Hasibuan",
                "Muhammad Arib Naufal Marpaung",
                "Farhan Al Zuhri Nasution",
                "Nurhaliza Syahfitri",
                "Liza Silvani Suheri",
                "Alya Febriani Lubis",
                "Amira Nurul Amanda",
                "M Haikal Alfansyah"};
        String[] email = {
                "zhafarsalim4@gmail.com",
                "muhammadridho.mr561@gmail.com",
                "ammar.rafi619@gmail.com",
                "arib.naufal12@gmail.com",
                "farhan.alzuhri@gmail.com",
                "nurhalizasyaf@gmail.com",
                "lizassuheri@gmail.com",
                "alyafebrianilubis@gmail.com",
                "amiraamandanurul@gmail.com",
                "Haikal_alfansyah@yahoo.com"};
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
                "181402001",
                "181402002",
                "181402003",
                "181402004",
                "181402005",
                "181402006",
                "181402007",
                "181402008",
                "181402009",
                "181402010"};
        String[] angkatan = {
                "2018",
                "2018",
                "2018",
                "2018",
                "2018",
                "2018",
                "2018",
                "2018",
                "2018",
                "2018"};
        String[] semester = {
                "7",
                "7",
                "7",
                "7",
                "7",
                "7",
                "7",
                "7",
                "7",
                "7"};

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