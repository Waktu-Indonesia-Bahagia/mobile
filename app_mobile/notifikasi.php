<?php
if (isset($_POST['title']) && isset($_POST['message'])) {
    $title = $_POST['title'];
    $message = $_POST['message'];

    require 'init.php';

    if ($con) {
        $title = mysqli_real_escape_string($con, $title);
        $message = mysqli_real_escape_string($con, $message);

        $sql = "INSERT INTO notifikasi (title, message) VALUES ('$title', '$message')";

        if (mysqli_query($con, $sql)) {
            echo json_encode(array("status" => "success"));
        } else {
            echo json_encode(array("status" => "error", "message" => mysqli_error($con), "query" => $sql));
        }
        
        mysqli_close($con);
    } else {
        echo json_encode(array("status" => "error", "message" => "Koneksi database gagal."));
    }
} else {
    echo json_encode(array("status" => "error", "message" => "Data tidak lengkap."));
}
?>
