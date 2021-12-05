package com.example.custom_listview;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.custom_listview.databinding.FragmentAngkatan2017Binding;

import java.util.ArrayList;

public class Angkatan2017 extends Fragment {

    FragmentAngkatan2017Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_angkatan2017, container, false);
        binding = FragmentAngkatan2017Binding.inflate(inflater, container, false);

        int[] imageId = {
                R.drawable.a17,
                R.drawable.b17,
                R.drawable.c17,
                R.drawable.d17,
                R.drawable.e17,
                R.drawable.f17,
                R.drawable.g17,
                R.drawable.h17,
                R.drawable.i17,
                R.drawable.j17};

        String[] nama = {
                "Ibnu Maulana",
                "Taufiq Rourkyendo",
                "Fakhri Rizha Ananda",
                "Miftah Rafid Syahrial",
                "Fani Theresa Hutabarat",
                "Muhammad Bayhaqi Daulay",
                "Gilbert Sorai Aro Sihura",
                "Fakhirah Mentaya",
                "Javic Rotanson",
                "Alvin Febriando"};
        String[] email = {
                "maulanaibnu562@yahoo.com",
                "robinhd300@gmail.com",
                "mr.fakhririzhaa@gmail.com",
                "miftahrafid@gmail.com",
                "fanitheresa@gmail.com",
                "bayhaqi101@gmail.com",
                "gilbertsihura@yahoo.com",
                "fakhirahmentaya@gmail.com",
                "jvc.rotanson@gmail.com",
                "alvinfebriando@outlook.com"};
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
                "171402025",
                "171402030",
                "171402043",
                "171402049",
                "171402061",
                "171402067",
                "171402071",
                "171402073",
                "171402075",
                "171402089"};
        String[] angkatan = {
                "2017",
                "2017",
                "2017",
                "2017",
                "2017",
                "2017",
                "2017",
                "2017",
                "2017",
                "2017"};
        String[] semester = {
                "9",
                "9",
                "9",
                "9",
                "9",
                "9",
                "9",
                "9",
                "9",
                "9"};

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