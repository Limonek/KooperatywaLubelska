<?php
include 'db/db_connect.php';
$orderDetail = array();
$orderDetailsArray = array();
$response = array();
if(isset($_GET['order_id'])){
	$orderId = $_GET['order_id'];
	$query = "SELECT id, quantity, product_id, tradeunit_id	FROM order_details WHERE order_id = ?";
	if($stmt = $con->prepare($query)){
		$stmt->bind_param("i",$orderId);
		$stmt->execute();
		$stmt->bind_result($id, $quantity, $productId, $tradeUnitId);
		while($stmt->fetch()){
			$orderDetail["id"] = $id;
			$orderDetail["quantity"] = $quantity;
			$orderDetail["productId"] = $productId;
			$orderDetail["tradeUnitId"] = $tradeUnitId;
			$orderDetailsArray[] = $orderDetail;
		}
		$stmt->close();
		$response["success"] = 1;
		$response["arrayList"] = $orderDetailsArray;
	}else{
		$response["success"] = 0;
		$response["message"] = mysqli_error($con);
	}
}else{
	$response["success"] = 0;
	$response["message"] = "missing parameter order_id";
}

//Display JSON response
echo json_encode($response);
?>