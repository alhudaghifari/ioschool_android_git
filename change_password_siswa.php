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
// $_POST['OldPassword'] = $pwddd;
// $pwdd = md5("bb");
// $pwddd = md5($pwdd);
// $_POST['NewPassword'] = $pwddd;

if (isset($_POST['Username']) && isset($_POST['OldPassword']) && isset($_POST['NewPassword'])) {

    // receiving the post params
    $Username = $_POST['Username'];
    $OldPassword = $_POST['OldPassword'];
    $NewPassword = $_POST['NewPassword'];
    // echo $Username . " " . $Password;


    // get the user by Username and Password
    // $user = $db->changePassword($Username, $OldPassword, $NewPassword);

    if ($db->changePassword($Username, $OldPassword, $NewPassword)) {
        // use is found
        $response["error"] = FALSE;
        $response["msg"] = "Password updated";
        
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

