<?php
$server = "localhost";
$username = "root";
$password = "";
$database = "db_pcc";

$dbh = new PDO("mysql:host=$server;dbname=$database", $username, $password);

$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
// echo 'connected';

?>