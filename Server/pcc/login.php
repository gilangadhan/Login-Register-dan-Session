<?php
require_once('koneksi.php');

if(isset($_POST['email_user']) && isset($_POST['pass_user'])){
	$email_user = $_POST['email_user'];
	$pass_user = $_POST['pass_user'];
	
	try{
		$sql = "select * from tbl_user where email_user = '".$email_user."' and pass_user = md5('".$pass_user."')";
		$ss = $dbh->prepare($sql);
		$ss->execute();
		$data = $ss->fetchAll(PDO::FETCH_OBJ);
		$size = $ss->rowCount();
		if($size > 0) {
			$json['pesan'] =  'Berhasil Login';
			$json['sukses'] = true;
			$json['user'] = $data;
			echo json_encode ($json);
		}else{
      		$json['pesan'] =  'Gagal Login';
			$json['sukses'] = false;
			echo json_encode ($json);
		}
	}catch(PDOException $e){
		    $json['pesan'] =  $e->getMessage();
			$json['sukses'] = false;
			echo json_encode ($json);
	}
}else{
	$json['pesan'] =  'Inputan sala';
	$json['sukses'] = false;
	echo json_encode ($json);
}
