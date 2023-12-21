<?php

$nama = $_POST['nama'];
$asal_kampus = $_POST['asal_kampus'];
$no_telp = $_POST['no_telp'];
$email = $_POST['email'];
$magang = $_POST['magang'];
$posisi = $_POST['posisi'];
$ktp = $_POST['ktp'];
$ktm = $_POST['ktm'];
$surat_permohonan = $_POST['surat_permohonan'];


require 'init.php';

if ($con) {
    $sql = "SELECT * FROM pendaftaran WHERE nama = '$nama'";
    $result = mysqli_query($con, $sql);

    if (mysqli_num_rows($result) > 0) {
        $status = "Ok";                                       
        $result_code = 0;
        echo json_encode(array('status' => $status, 'result_code' => $result_code));
    } else {
        $sql = "INSERT into pendaftaran(nama, asal_kampus, no_telp, email, magang, posisi, ktp, ktm, surat_permohonan) value('$nama', '$asal_kampus', '$no_telp', '$email', '$magang', '$posisi', '$ktp', '$ktm', '$surat_permohonan')";
        if (mysqli_query($con, $sql)) {
            $status = "ok"; 
            $result_code = 1;
            echo json_encode(array('status' => $status, 'result_code' => $result_code));
        } else {
            $status = "failed";
            echo json_encode(array('status' => $status, 'error' => mysqli_error($con)), JSON_FORCE_OBJECT);
        }
    }
} else {
    $status = "failed";
    echo json_encode(array('status' => $status, 'error' => mysqli_connect_error()), JSON_FORCE_OBJECT);
}

mysqli_close($con);
?>
