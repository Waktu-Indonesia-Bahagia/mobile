<?php
$id = $_POST['id'];
$nama = $_POST['nama'];
$asal_kampus = $_POST['asal_kampus'];
$no_telepon = $_POST['no_telepon'];
$respone = array();

require 'init.php';
$sql = "UPDATE mahasiswa SET nama = '$nama', asal_kampus = '$asal_kampus', no_telepon = '$no_telepon' WHERE id = '$id'";

if (mysqli_query($con, $sql)) {
    $respone["value"] = 1;
    $respone["message"] = "Berhasil memperbaharui";
    echo json_encode($respone);
} else {
    $respone["value"] = 0;
    $respone["message"] = "Gagal Memperbaharui";
    echo json_encode($respone);
}

mysqli_close($con);
