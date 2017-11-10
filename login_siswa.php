<?php

/**
 * @author Ravi Tamada
 * @link http://www.androidhive.info/2012/01/android-login-and-registration-with-php-mysql-and-sqlite/ Complete tutorial
 */

require_once 'include/DB_Functions.php';
$db = new DB_Functions();

// json response array
$response = array("error" => FALSE);

//dummy login
// $_POST['Username'] = "bb";
// $pwdd = md5("ww");
// $pwddd = md5($pwdd);
// $_POST['Password'] = $pwddd;

if (isset($_POST['Username']) && isset($_POST['Password'])) {

    // receiving the post params
    $Username = $_POST['Username'];
    $Password = $_POST['Password'];
    // echo $Username . " " . $Password;


    // get the user by Username and Password
    $user = $db->getUserByUsernameAndPassword($Username, $Password);

    if ($user != false) {
        // use is found
        $response["error"] = FALSE;
        $response["NIS"] = $user["NIS"];
        $response["user"]["Namalengkap"] = $user["Namalengkap"];
        $response["user"]["Username"] = $user["Username"];
        $response["user"]["Angkatan"] = $user["Angkatan"];
        $response["user"]["namasekolah"] = $user["namasekolah"];
        
        echo json_encode($response);
    } else {
        // user is not found with the credentials
        $response["error"] = TRUE;
        $response["error_msg"] = "I'm sorry but I think you enter wrong username or password.";
        echo json_encode($response);
    }
} else {
    // required post params is missing
    $response["error"] = TRUE;
    $response["error_msg"] = "Required parameters Username or Password is missing!";
    echo json_encode($response);
}
?>

