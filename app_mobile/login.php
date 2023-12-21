<?php
$name = $_POST['name'];
$password = $_POST['password'];

require 'init.php';

if($con){
    $sql = "SELECT * FROM user WHERE name = '$name' AND password = '$password'";
    $result = mysqli_query($con,$sql);
    if(mysqli_num_rows ($result)>0){
        $row = mysqli_fetch_assoc($result);
        $status = "ok";
        $result_code = 1;
        $name = $row['name'];
        echo json_encode(array('status'=> $status, 'result_code'=> $result_code, 'name' => $name));
    }else{
        $status = "ok";
        $result_code = 0;
        echo json_encode(array('status'=> $status, 'result_code'=> $result_code,));
    }
}else{
    $status = "failed";
    echo json_encode(array('status'=>$status),JSON_FORCE_OBJECT);
}
mysqli_close($con);
?>