<?php

/*
 * Following code will get single product details
 * A product is identified by product id (pid)
 */

// array for JSON response
$response = array();


// include db connect class
require_once __DIR__ . '/db_connect.php';

// connecting to db
$db = new DB_CONNECT();

// check for post data
if (isset($_GET["pid"])) {
    $Registration_number_ID = $_GET['Registration_number_ID'];

    // get a product from products table
    $result = mysql_query("SELECT *FROM Vehicle_key_info WHERE Registration_number_ID = $Registration_number_ID");

    if (!empty($result)) {
        // check for empty result
        if (mysql_num_rows($result) > 0) {

            $result = mysql_fetch_array($result);

            $Vehicle = array();
            $Vehicle["Registration_number_ID"] = $row["Registration_number_ID"];
            $Vehicle["Vehicle_type"] = $row["Vehicle_type"];
            $Vehicle["Fleet_Number"] = $row["Fleet_Number"];
            $Vehicle["Commission_year"] = $row["Commission_year"];
            $Vehicle["Decommission_year"] = $row["Decommission_year"];
            $Vehicle["Vehicle_image"] = $row["Vehicle_image"];
            $Vehicle["Video"] = $row["Video"];
            // success
            $response["success"] = 1;

            // user node
            $response["Vehicle"] = array();

            array_push($response["Vehicle"], $Vehicle);

            // echoing JSON response
            echo json_encode($response);
        } else {
            // no product found
            $response["success"] = 0;
            $response["message"] = "No product found";

            // echo no users JSON
            echo json_encode($response);
        }
    } else {
        // no product found
        $response["success"] = 0;
        $response["message"] = "No product found";

        // echo no users JSON
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";

    // echoing JSON response
    echo json_encode($response);
}
?>