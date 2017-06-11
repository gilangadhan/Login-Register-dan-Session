<?php
require_once('koneksi.php');

if(
isset($_POST['nama_user']) &&
isset($_POST['email_user']) &&
isset($_POST['pass_user']) &&
isset($_POST['no_user']) &&
isset($_POST['alamat_user']) &&
isset($_POST['jabatan_user'])){
	$email_user = $_POST['email_user'];
	$pass_user = $_POST['pass_user'];
	$no_user = $_POST['no_user'];
	$alamat_user = $_POST['alamat_user'];
	$jabatan_user = $_POST['jabatan_user'];
	$nama_user = $_POST['nama_user'];
	
	try{
		$sql = "insert into tbl_user 
		(id_user, 
		nama_user, 
		email_user, 
		pass_user, 
		no_user, 
		alamat_user, 
		jabatan_user) 
		values 
		(NULL, 
		'".$nama_user."', 
		'".$email_user."',
		md5('".$pass_user."'),
		'".$no_user."',
		'".$alamat_user."', 
		'".$jabatan_user."')";

		$ss = $dbh->prepare($sql);
		$ss->execute();
		
		if($ss) {
			$json['pesan'] =  'Berhasil Sign up';
			$json['sukses'] = true;
			echo json_encode ($json);
		}else{
      		$json['pesan'] =  'Gagal Sign Up';
			$json['sukses'] = false;
			echo json_encode ($json);
		}
	}catch(PDOException $e){
		    $json['pesan'] =  $e->getMessage();
			$json['sukses'] = false;
			echo json_encode ($json);
	}
}else{
	$json['pesan'] =  'Inputan salah';
	$json['sukses'] = false;
	echo json_encode ($json);
}
