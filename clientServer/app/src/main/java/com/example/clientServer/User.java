package com.example.clientServer;

public class User {

    String nama, email, fakultas, prodi, status, nim, angkatan, semester;
    int imageID;

    public User(String nama, String email, String fakultas, String prodi, String status, int imageID, String nim, String angkatan, String semester) {
        this.nama = nama;
        this.email = email;
        this.fakultas = fakultas;
        this.prodi = prodi;
        this.status = status;
        this.imageID = imageID;
        this.nim = nim;
        this.angkatan = angkatan;
        this.semester = semester;
    }
}
