<?php

/**
 * @author Ravi Tamada
 * @link http://www.androidhive.info/2012/01/android-login-and-registration-with-php-mysql-and-sqlite/ Complete tutorial
 */

require_once 'include/DB_Functions.php';
$db = new DB_Functions();

// json response array
$response = array("error" => FALSE);


//dummy
$_POST['NIS'] = "2017002";
$_POST['Namalengkap'] = "sukarno";
$_POST['Username'] = "fff";
$_POST['Password'] = "ff";
$_POST['Angkatan'] = "2013";
$_POST['id_sekolah'] = "1709030001";

if (isset($_POST['NIS']) && isset($_POST['Namalengkap']) && isset($_POST['Username']) && isset($_POST['Password']) && isset($_POST['Angkatan']) && isset($_POST['id_sekolah']) ) {

    // receiving the post params
    $NIS = $_POST['NIS'];
    $Namalengkap = $_POST['Namalengkap'];
    $Username = $_POST['Username'];
    $Password = $_POST['Password'];
    $Angkatan = $_POST['Angkatan'];
    $id_sekolah = $_POST['id_sekolah'];

    // check if user is already existed with the same Username
    if ($db->isUserExisted($Username)) {
        // user already existed
        $response["error"] = TRUE;
        $response["error_msg"] = "User already existed with " . $Username;
        echo json_encode($response);
    } else {
        // create a new user
        $user = $db->storeUser($NIS, $Namalengkap, $Username, $Password, $Angkatan, $id_sekolah);
        if ($user) {
            // user stored successfully
            $response["error"] = FALSE;
            $response["NIS"] = $user["NIS"];
            $response["user"]["Namalengkap"] = $user["Namalengkap"];
            $response["user"]["Username"] = $user["Username"];
            $response["user"]["Password"] = $user["Password"];
            $response["user"]["Angkatan"] = $user["Angkatan"];
            $response["user"]["id_sekolah"] = $user["id_sekolah"];
            echo json_encode($response);
        } else {
            // user failed to store
            $response["error"] = TRUE;
            $response["error_msg"] = "Unknown error occurred in registration!";
            echo json_encode($response);
        }
    }
} else {
    $response["error"] = TRUE;
    $response["error_msg"] = "Required parameters (NIS, Namalengkap, Username, Password, Angkatan, or id_sekolah) is missing!";
    echo json_encode($response);
}
?>

