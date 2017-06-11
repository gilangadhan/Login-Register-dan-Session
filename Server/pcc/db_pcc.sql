-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 11, 2017 at 10:16 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pcc`
--
CREATE DATABASE IF NOT EXISTS `db_pcc` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `db_pcc`;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id_user` int(11) NOT NULL,
  `nama_user` varchar(100) NOT NULL,
  `email_user` varchar(100) NOT NULL,
  `pass_user` varchar(200) NOT NULL,
  `jabatan_user` varchar(50) NOT NULL,
  `no_user` varchar(20) NOT NULL,
  `alamat_user` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`id_user`, `nama_user`, `email_user`, `pass_user`, `jabatan_user`, `no_user`, `alamat_user`) VALUES
(1, 'Gilang Ramadhan', 'gilang@gmail.com', 'c37fddfb7b3f538674c6e9a77e7bf486', 'Admin Gagal', '081904996393', 'Semarang'),
(2, 'q', 'q', '7694f4a66316e53c8cdd9d9954bd611d', 'q', 'q', 'q'),
(3, 'h', 'h', 'h', 'h', 'h', 'h'),
(4, 'nganu', 'nganu@gmail.com', 'd1a6f896a111b237d8ff8dc4ac623809', 'nganu', '081', 'Semarang');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
