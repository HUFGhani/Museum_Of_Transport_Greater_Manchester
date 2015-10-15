<?php

/*
 * Following code will list all the Vehicles
 */

// array for JSON response
$response = array();


// include db connect class
require_once __DIR__ . '/db_connect.php';

// connecting to db
$db = new DB_CONNECT();

// get all Vehicles from Vehicles table
$result = mysql_query("SELECT *FROM Vehicle_key_info") or die(mysql_error());

// check for empty result
if (mysql_num_rows($result) > 0) {
    // looping through all results
    // Vehicles node
    $response["Vehicles"] = array();
    
    while ($row = mysql_fetch_array($result)) {
        // temp user array
        $Vehicle = array();
        $Vehicle["Registration_number_ID"] = $row["Registration_number_ID"];
        $Vehicle["Vehicle_type"] = $row["Vehicle_type"];
        $Vehicle["Fleet_Number"] = $row["Fleet_Number"];
        $Vehicle["Commission_year"] = $row["Commission_year"];
        $Vehicle["Decommission_year"] = $row["Decommission_year"];
        $Vehicle["Vehicle_image"] = $row["Vehicle_image"];
        $Vehicle["Video"] = $row["Video"];



        // push single Vehicle into final response array
        array_push($response["Vehicles"], $Vehicle);
    }
    // success
    $response["success"] = 1;

    // echoing JSON response
    echo json_encode($response);
} else {
    // no Vehicles found
    $response["success"] = 0;
    $response["message"] = "No Vehicles found";

    // echo no users JSON
    echo json_encode($response);
}
?>
