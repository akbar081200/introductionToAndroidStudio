<?php
require("koneksi.php");

$response = array();

if($_SERVER['REQUEST_METHOD'] == 'POST'){

    $id_mhs = $_POST["id_mhs"];
    $nama = $_POST["nama"];
    $nim = $_POST["nim"];
    $email = $_POST["email"];
    $angkatan = $_POST["angkatan"];
    $fakultas = $_POST["fakultas"];
    $prodi = $_POST["prodi"];
    $semester = $_POST["semester"];
    $status = $_POST["status"];

    $perintah = "UPDATE mahasiswa SET nama = '$nama', email = '$email', fakultas = '$fakultas', prodi = '$prodi', status = '$status', imageID = 1, nim = '$nim', angkatan = '$angkatan', semester = '$semester' WHERE id_mhs = '$id_mhs'";
    $eksekusi = mysqli_query($konek, $perintah);
    $cek = mysqli_affected_rows($konek);

    if($cek > 0){
        $response["kode"] = 1;
        $response["pesan"] = "Data Berhasil Diubah";
    }
    else{
        $response["kode"] = 0;
        $response["pesan"] = "Data Gagal Diubah";
    }
}
else{
    $response["kode"] = 0;
    $response["pesan"] = "Tidak ada Post Data";
}

echo json_encode($response);
mysqli_close($konek);

