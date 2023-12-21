<?php

$name = $_POST['name'];
$password = $_POST['password'];
$email = $_POST['email'];


require 'init.php';

if ($con) {
    $sql = "SELECT * FROM user WHERE name = '$name'";
    $result = mysqli_query($con, $sql);

    if (mysqli_num_rows($result) > 0) {
        $status = "Ok";
        $result_code = 0;
        echo json_encode(array('status' => $status, 'result_code' => $result_code));
    } else {
        $sql = "INSERT into user(name,password,email) value('$name','$password','$email')";
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
