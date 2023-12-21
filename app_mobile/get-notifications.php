<?php
require 'init.php';

$response = array();

if ($con) {
    $sql = "SELECT * FROM notifikasi";
    $result = mysqli_query($con, $sql);

    if ($result) {
        $notifications = array();
        while ($row = mysqli_fetch_assoc($result)) {
            $notification = array('title' => $row['title']);
            $notifications[] = $notification;
        }

        $response['status'] = "success";
        $response['data'] = $notifications;
    } else {
        $response['status'] = "error";
        $response['message'] = "Error executing query: " . mysqli_error($con);
    }

    mysqli_close($con);
} else {
    $response['status'] = "error";
    $response['message'] = "Failed to connect to the database.";
}

// Return a JSON response
echo json_encode($response);
?>
