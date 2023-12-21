<?php
$oldpass = $_POST['old_password'];
$newpass = $_POST['new_password'];
$conformpass = $_POST['conform_password'];
require 'init.php';

$sql = "SELECT * FROM user WHERE password = '$oldpass'";
$query = mysqli_query($con, $sql);

if ($newpass == $conformpass) {
    if (mysqli_num_rows($query) > 0) {
        $user = mysqli_fetch_assoc($query);
        $user_id = $user['id'];

        $update = "UPDATE user SET password = '$newpass' WHERE id = '$user_id'";
        $res = mysqli_query($con, $update);

        if ($res) {
            $response = array('status' => 'success', 'message' => 'Kata Sandi berhasil diubah!');
        } else {
            $response = array('status' => 'error', 'message' => 'Gagal mengubah Kata Sandi!');
        }
    } else {
        $response = array('status' => 'error', 'message' => 'Kata Sandi Lama Tidak Sama!');
    }
} else {
    $response = array('status' => 'error', 'message' => 'Kata Sandi tidak sama!');
}

echo json_encode($response);
?>
