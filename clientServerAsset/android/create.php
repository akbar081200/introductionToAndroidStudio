<?php
require("koneksi.php");

$response = array();

if($_SERVER['REQUEST_METHOD'] == 'POST'){

    $nama = $_POST["nama"];
    $nim = $_POST["nim"];
    $email = $_POST["email"];
    $angkatan = $_POST["angkatan"];
    $fakultas = $_POST["fakultas"];
    $prodi = $_POST["prodi"];
    $semester = $_POST["semester"];
    $status = $_POST["status"];

    $perintah = "INSERT INTO mahasiswa (nama, email, fakultas, prodi, status, imageID, nim, angkatan, semester) VALUES('$nama','$email','$fakultas','$prodi','$status',1,'$nim','$angkatan','$semester')";
    $eksekusi = mysqli_query($konek, $perintah);
    $cek = mysqli_affected_rows($konek);

    if($cek > 0){
        $response["kode"] = 1;
        $response["pesan"] = "Simpan Data Berhasil";
    }
    else{
        $response["kode"] = 0;
        $response["pesan"] = "Gagal Menyimpan Data";
    }
}
else{
    $response["kode"] = 0;
    $response["pesan"] = "Tidak ada Post Data";
}

echo json_encode($response);
mysqli_close($konek);