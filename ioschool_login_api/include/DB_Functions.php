<?php

/**
 * @author Ravi Tamada
 * @link http://www.androidhive.info/2012/01/android-login-and-registration-with-php-mysql-and-sqlite/ Complete tutorial
 */

class DB_Functions {

    private $conn;

    // constructor
    function __construct() {
        require_once 'DB_Connect.php';
        // connecting to database
        $db = new Db_Connect();
        $this->conn = $db->connect();
    }

    // destructor
    function __destruct() {
        
    }

    /**
     * Storing new user
     * returns user details
     */
    public function storeUser($NIS, $Namalengkap, $Username, $Password, $Angkatan, $id_sekolah) {
        $encrypted_password1 = md5($Password); // encrypted Password
        $encrypted_password = md5($encrypted_password1);

        $stmt = $this->conn->prepare("INSERT INTO siswa(NIS, Namalengkap, Username, Password, Angkatan, id_sekolah) VALUES(?, ?, ?, ?, ?, ?)");
        $stmt->bind_param("isssii",$NIS, $Namalengkap, $Username, $encrypted_password, $Angkatan, $id_sekolah);
        $result = $stmt->execute();
        $stmt->close();

        // check for successful store
        if ($result) {
            $stmt = $this->conn->prepare("SELECT * FROM siswa WHERE Username = ?");
            $stmt->bind_param("s", $Username);
            $stmt->execute();
            $user = $stmt->get_result()->fetch_assoc();
            $stmt->close();

            return $user;
        } else {
            return false;
        }
    }

    /**
     * Get user by NIS and Password
     */
    public function getUserByUsernameAndPassword($Username, $Password) {

        $stmt = $this->conn->prepare("SELECT * FROM siswa WHERE Username = ?");

        $stmt->bind_param("s", $Username);

        if ($stmt->execute()) {
            $user = $stmt->get_result()->fetch_assoc();
            $stmt->close();

            // $encrypted_password1 = md5($Password);
            // $encrypted_password = md5($encrypted_password1);

            $pwd = $user['Password'];

            // check for Password equality
            if ($Password == $pwd) {
                // user authentication details are correct
                return $user;
            }
        } else {
            return NULL;
        }
    }

    /**
     * Check user is existed or not
     */
    public function isUserExisted($Username) {
        $stmt = $this->conn->prepare("SELECT Username from siswa WHERE Username = ?");

        $stmt->bind_param("s", $Username);

        $stmt->execute();

        $stmt->store_result();

        if ($stmt->num_rows > 0) {
            // user existed 
            $stmt->close();
            return true;
        } else {
            // user not existed
            $stmt->close();
            return false;
        }
    }

}

?>
