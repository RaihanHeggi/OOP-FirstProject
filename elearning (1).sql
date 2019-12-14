-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2019 at 11:29 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `elearning`
--

-- --------------------------------------------------------

--
-- Table structure for table `kelastable`
--

CREATE TABLE `kelastable` (
  `ID_KELAS` varchar(100) NOT NULL,
  `NAMAKELAS` varchar(100) NOT NULL,
  `ID_MAPEL` varchar(100) DEFAULT NULL,
  `ID_MATERI` varchar(100) DEFAULT NULL,
  `NAMA_TENTOR` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kelastable`
--

INSERT INTO `kelastable` (`ID_KELAS`, `NAMAKELAS`, `ID_MAPEL`, `ID_MATERI`, `NAMA_TENTOR`) VALUES
('KELAS-1', 'KALKULUS', 'INTEGRAL-1', 'DISKRET-1', 'SUPARJO');

-- --------------------------------------------------------

--
-- Table structure for table `listkelastentor`
--

CREATE TABLE `listkelastentor` (
  `ID` int(100) NOT NULL,
  `ID_KELASLT` varchar(100) NOT NULL,
  `NAMAKELASLT` varchar(100) NOT NULL,
  `NAMATENTORLT` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `listkelastentor`
--

INSERT INTO `listkelastentor` (`ID`, `ID_KELASLT`, `NAMAKELASLT`, `NAMATENTORLT`) VALUES
(8, 'KELAS-1', 'KALKULUS', 'SUPARJO');

-- --------------------------------------------------------

--
-- Table structure for table `liststudenttable`
--

CREATE TABLE `liststudenttable` (
  `ID` int(100) NOT NULL,
  `ID_KELASLIST` varchar(100) NOT NULL,
  `NAMA_KELASLIST` varchar(100) NOT NULL,
  `ID_SISWA` varchar(100) NOT NULL,
  `NAMATENTOR` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `liststudenttable`
--

INSERT INTO `liststudenttable` (`ID`, `ID_KELASLIST`, `NAMA_KELASLIST`, `ID_SISWA`, `NAMATENTOR`) VALUES
(2, 'KELAS-1', 'KALKULUS', '1301184219', 'SUPARJO'),
(3, 'KELAS-1', 'KALKULUS', '1301184225', 'SUPARJO');

-- --------------------------------------------------------

--
-- Table structure for table `matapelajarantable`
--

CREATE TABLE `matapelajarantable` (
  `ID_MAPEL` varchar(100) NOT NULL,
  `NAMAMAPEL` varchar(100) NOT NULL,
  `ID_KELAS` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `matapelajarantable`
--

INSERT INTO `matapelajarantable` (`ID_MAPEL`, `NAMAMAPEL`, `ID_KELAS`) VALUES
('INTEGRAL-1', 'INTEGRAL PERKENALAN', 'KELAS-1');

-- --------------------------------------------------------

--
-- Table structure for table `materitable`
--

CREATE TABLE `materitable` (
  `ID` int(100) NOT NULL,
  `ID_MATERI` varchar(100) NOT NULL,
  `NAMAMATERI` varchar(100) NOT NULL,
  `ID_KELAS` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `materitable`
--

INSERT INTO `materitable` (`ID`, `ID_MATERI`, `NAMAMATERI`, `ID_KELAS`) VALUES
(9, 'INTEGRAL-DASAR', 'INTEGRAL LIMIT', 'KELAS-1'),
(10, 'INTEGRAL-DASAR', 'INTEGRAL TENTU', 'KELAS-1'),
(12, 'INTEGRAL-DASAR', 'INTEGRAL TAK TENTU', 'KELAS-1');

-- --------------------------------------------------------

--
-- Table structure for table `studenttable`
--

CREATE TABLE `studenttable` (
  `ID_SISWA` varchar(100) NOT NULL,
  `NAMA` varchar(100) DEFAULT NULL,
  `UMUR` int(100) NOT NULL,
  `USERNAME` varchar(100) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `studenttable`
--

INSERT INTO `studenttable` (`ID_SISWA`, `NAMA`, `UMUR`, `USERNAME`, `PASSWORD`) VALUES
('1301184219', 'Raihan', 19, 'PelajarSehat', '123456'),
('1301184225', 'Dhimas', 19, 'Dhimas', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `tentortable`
--

CREATE TABLE `tentortable` (
  `ID_TENTOR` varchar(100) NOT NULL,
  `NAMA` varchar(100) NOT NULL,
  `UMUR` int(100) NOT NULL,
  `USERNAME` varchar(100) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tentortable`
--

INSERT INTO `tentortable` (`ID_TENTOR`, `NAMA`, `UMUR`, `USERNAME`, `PASSWORD`) VALUES
('TENTOR-1', 'SUPARJO', 51, 'SUPARJOKU', '123456');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kelastable`
--
ALTER TABLE `kelastable`
  ADD PRIMARY KEY (`ID_KELAS`);

--
-- Indexes for table `listkelastentor`
--
ALTER TABLE `listkelastentor`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `liststudenttable`
--
ALTER TABLE `liststudenttable`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `matapelajarantable`
--
ALTER TABLE `matapelajarantable`
  ADD PRIMARY KEY (`ID_MAPEL`);

--
-- Indexes for table `materitable`
--
ALTER TABLE `materitable`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `studenttable`
--
ALTER TABLE `studenttable`
  ADD PRIMARY KEY (`ID_SISWA`);

--
-- Indexes for table `tentortable`
--
ALTER TABLE `tentortable`
  ADD PRIMARY KEY (`ID_TENTOR`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `listkelastentor`
--
ALTER TABLE `listkelastentor`
  MODIFY `ID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `liststudenttable`
--
ALTER TABLE `liststudenttable`
  MODIFY `ID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `materitable`
--
ALTER TABLE `materitable`
  MODIFY `ID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
