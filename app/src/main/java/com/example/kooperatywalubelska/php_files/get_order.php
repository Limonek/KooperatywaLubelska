<?php
include 'db/db_connect.php';
$response = array();
if(isset($_GET['user_id']) && isset($_GET['date'])){
	$userId = $_GET['user_id'];
	$date = $_GET['date'];
	$query = "SELECT id, user_id, date FROM orders WHERE user_id = $userId and `date` = '$date'";
	if($stmt = $con->prepare($query)){
		$stmt->execute();
		$stmt->bind_result($id, $userId, $date);
		if($stmt->fetch()){
			$response["id"] = $id;
			$response["userId"] = $userId;
			$response["date"] = $date;
			$response["success"] = 1;

		}else{
			$response["success"] = 0;
			$response["message"] = "Order not found";
		}
		$stmt->close();
	}else{
		$response["success"] = 0;
		$response["message"] = mysqli_error($con);
	}
}else{
	$response["success"] = 0;
	$response["message"] = "missing parameter user_id or date";
}

//Display JSON response
echo json_encode($response);
?>