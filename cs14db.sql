-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2019 at 05:00 AM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cs14db`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `UserName` varchar(256) NOT NULL,
  `Password` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`UserName`, `Password`) VALUES
('abc', '7456'),
('admin', '1234'),
('user', '9876');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `VehicleID` varchar(10) NOT NULL,
  `OwnerID` varchar(32) NOT NULL,
  `NumServices` int(5) NOT NULL,
  `RegDate` date NOT NULL,
  `Type` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`VehicleID`, `OwnerID`, `NumServices`, `RegDate`, `Type`) VALUES
('sr', '7912455v', 0, '2019-05-08', 'Nissan March'),
('CAB-0314', '977932335v', 0, '2019-05-01', 'Toyota Aqua');

-- --------------------------------------------------------

--
-- Table structure for table `vehicleowner`
--

CREATE TABLE `vehicleowner` (
  `OID` varchar(32) NOT NULL,
  `OwnerName` varchar(256) NOT NULL,
  `Address` varchar(256) NOT NULL,
  `ContactNum` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicleowner`
--

INSERT INTO `vehicleowner` (`OID`, `OwnerName`, `Address`, `ContactNum`) VALUES
('977865422v', 'A Dissanayake', 'Gampola,Kandy', '0712345678'),
('asdas', 'sadsd', 'asdsad', '0123456488'),
('qweq', 'qweq', 'qeq', 'qeq');

-- --------------------------------------------------------

--
-- Table structure for table `vehicleservices`
--

CREATE TABLE `vehicleservices` (
  `ServiceID` varchar(10) NOT NULL,
  `Date` date NOT NULL,
  `VehicleID` varchar(16) NOT NULL,
  `Payment` int(6) NOT NULL,
  `Description` varchar(512) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`UserName`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
