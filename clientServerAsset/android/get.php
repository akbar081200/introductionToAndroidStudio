<?php
require("koneksi.php");

$response = array();

if($_SERVER['REQUEST_METHOD'] == 'POST'){

    $id_mhs = $_POST["id_mhs"];

    $perintah = "SELECT * FROM mahasiswa WHERE id_mhs = '$id_mhs'";
    $eksekusi = mysqli_query($konek, $perintah);
    $cek = mysqli_affected_rows($konek);

    if($cek > 0){
        $response["kode"] = 1;
        $response["pesan"] = "Data Tersedia";
        $response["data"] = array();

        while($ambil = mysqli_fetch_object($eksekusi)){
            $F["id_mhs"] = $ambil->id_mhs;
            $F["nama"] = $ambil->nama;
            $F["email"] = $ambil->email;
            $F["fakultas"] = $ambil->fakultas;
            $F["prodi"] = $ambil->prodi;
            $F["status"] = $ambil->status;
            $F["imageID"] = $ambil->imageID;
            $F["nim"] = $ambil->nim;
            $F["angkatan"] = $ambil->angkatan;
            $F["semester"] = $ambil->semester;

            array_push($response["data"],$F);
        }
    }
    else{
        $response["kode"] = 0;
        $response["pesan"] = "Data Tidak Tersedia";
    }
}
else{
    $response["kode"] = 0;
    $response["pesan"] = "Tidak ada Post Data";
}

echo json_encode($response);
mysqli_close($konek);