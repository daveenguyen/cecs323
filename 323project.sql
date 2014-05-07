-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 07, 2014 at 07:43 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `323project`
--
CREATE DATABASE IF NOT EXISTS `323project` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `323project`;

-- --------------------------------------------------------

--
-- Table structure for table `arrivetime`
--

CREATE TABLE IF NOT EXISTS `arrivetime` (
  `routeNum` int(3) NOT NULL,
  `stopNum` int(3) NOT NULL,
  `time` time NOT NULL,
  PRIMARY KEY (`routeNum`,`stopNum`,`time`),
  KEY `stop_arrivetime_FK` (`stopNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='The time at which a public conveyance is scheduled to appear at a given destinat';

--
-- Dumping data for table `arrivetime`
--

INSERT INTO `arrivetime` (`routeNum`, `stopNum`, `time`) VALUES
(81, 1, '14:09:00'),
(81, 1, '15:04:00'),
(81, 1, '15:49:00'),
(81, 1, '16:34:00'),
(81, 2, '14:01:00'),
(81, 2, '14:56:00'),
(81, 2, '15:41:00'),
(81, 2, '16:26:00'),
(104, 3, '14:45:00'),
(104, 3, '16:05:00'),
(104, 3, '17:25:00'),
(151, 4, '14:20:00'),
(151, 4, '15:00:00'),
(151, 4, '15:40:00'),
(151, 4, '16:20:00'),
(151, 4, '17:00:00'),
(151, 5, '14:00:00'),
(151, 5, '14:40:00'),
(151, 5, '15:20:00'),
(151, 5, '16:00:00'),
(151, 5, '16:40:00'),
(151, 6, '13:52:00'),
(151, 6, '14:32:00'),
(151, 6, '15:12:00'),
(151, 6, '15:52:00'),
(151, 6, '16:32:00'),
(21, 7, '14:35:00'),
(21, 7, '15:34:00'),
(21, 7, '16:34:00'),
(81, 8, '13:55:00'),
(81, 8, '14:50:00'),
(81, 8, '15:35:00'),
(81, 8, '16:20:00'),
(21, 9, '14:32:00'),
(21, 9, '15:31:00'),
(21, 9, '16:31:00'),
(61, 10, '14:14:00'),
(61, 10, '15:26:00'),
(61, 10, '16:38:00'),
(71, 10, '13:39:00'),
(71, 10, '14:39:00'),
(71, 10, '15:39:00'),
(71, 10, '16:39:00'),
(21, 11, '15:06:00'),
(21, 11, '16:06:00'),
(21, 11, '17:06:00'),
(45, 11, '14:26:00'),
(45, 11, '14:56:00'),
(45, 11, '15:32:00'),
(45, 11, '16:02:00'),
(45, 11, '16:34:00'),
(45, 11, '17:06:00'),
(45, 12, '14:34:00'),
(45, 12, '15:04:00'),
(45, 12, '15:40:00'),
(45, 12, '16:10:00'),
(45, 12, '16:42:00'),
(45, 12, '17:13:00'),
(1, 13, '14:20:00'),
(1, 13, '15:20:00'),
(1, 13, '16:22:00'),
(181, 14, '13:49:00'),
(181, 14, '14:29:00'),
(181, 14, '15:09:00'),
(181, 14, '15:49:00'),
(181, 14, '16:29:00'),
(45, 15, '14:13:00'),
(45, 15, '14:43:00'),
(45, 15, '15:19:00'),
(45, 15, '15:49:00'),
(45, 15, '16:21:00'),
(45, 15, '16:55:00'),
(171, 15, '14:21:00'),
(171, 15, '15:20:00'),
(171, 15, '16:20:00'),
(181, 16, '14:00:00'),
(181, 16, '14:40:00'),
(181, 16, '15:20:00'),
(181, 16, '16:00:00'),
(181, 16, '16:40:00'),
(45, 17, '14:40:00'),
(45, 17, '15:10:00'),
(45, 17, '15:46:00'),
(45, 17, '16:16:00'),
(45, 17, '16:48:00'),
(45, 17, '17:19:00'),
(45, 18, '14:16:00'),
(45, 18, '14:46:00'),
(45, 18, '15:22:00'),
(45, 18, '15:52:00'),
(45, 18, '16:24:00'),
(45, 18, '16:57:00'),
(81, 19, '13:49:00'),
(81, 19, '14:44:00'),
(81, 19, '15:29:00'),
(81, 19, '16:14:00'),
(61, 20, '14:54:00'),
(61, 20, '16:10:00'),
(61, 20, '17:19:00'),
(71, 20, '15:22:00'),
(71, 20, '16:22:00'),
(71, 20, '17:22:00'),
(61, 21, '15:04:00'),
(61, 21, '16:20:00'),
(61, 21, '17:29:00'),
(61, 23, '14:36:00'),
(61, 23, '15:50:00'),
(61, 23, '17:00:00'),
(61, 24, '14:45:00'),
(61, 24, '16:00:00'),
(61, 24, '17:10:00'),
(61, 25, '14:25:00'),
(61, 25, '15:38:00'),
(61, 25, '16:49:00'),
(21, 26, '15:13:00'),
(21, 26, '16:13:00'),
(21, 26, '17:13:00'),
(171, 27, '14:11:00'),
(171, 27, '15:10:00'),
(171, 27, '16:10:00'),
(21, 28, '14:49:00'),
(21, 28, '15:48:00'),
(21, 28, '16:48:00'),
(71, 29, '13:58:00'),
(71, 29, '14:58:00'),
(71, 29, '15:58:00'),
(71, 29, '16:58:00'),
(171, 30, '14:35:00'),
(171, 30, '15:35:00'),
(171, 30, '16:35:00'),
(21, 31, '14:42:00'),
(21, 31, '15:41:00'),
(21, 31, '16:41:00'),
(21, 32, '14:57:00'),
(21, 32, '15:57:00'),
(21, 32, '16:57:00'),
(104, 32, '14:29:00'),
(104, 32, '15:49:00'),
(104, 32, '17:10:00'),
(104, 33, '13:47:00'),
(104, 33, '15:07:00'),
(104, 33, '16:28:00'),
(1, 35, '14:35:00'),
(1, 35, '15:36:00'),
(1, 35, '16:37:00'),
(104, 36, '13:58:00'),
(104, 36, '15:18:00'),
(104, 36, '16:39:00'),
(171, 37, '13:58:00'),
(171, 37, '15:55:00'),
(151, 38, '14:05:00'),
(151, 38, '14:45:00'),
(151, 38, '15:25:00'),
(151, 38, '16:05:00'),
(151, 38, '16:45:00'),
(21, 39, '14:28:00'),
(21, 39, '15:27:00'),
(21, 39, '16:27:00'),
(71, 39, '14:21:00'),
(104, 40, '14:20:00'),
(104, 40, '15:40:00'),
(104, 40, '17:01:00'),
(104, 41, '14:13:00'),
(104, 41, '15:33:00'),
(104, 41, '16:54:00'),
(171, 42, '14:43:00'),
(171, 42, '15:43:00'),
(171, 42, '16:43:00'),
(104, 43, '14:36:00'),
(104, 43, '15:56:00'),
(104, 43, '17:17:00'),
(104, 44, '13:54:00'),
(104, 44, '15:13:00'),
(104, 44, '16:34:00'),
(71, 45, '14:06:00'),
(71, 45, '15:07:00'),
(71, 45, '16:07:00'),
(71, 45, '17:07:00'),
(71, 46, '13:50:00'),
(71, 46, '14:50:00'),
(71, 46, '15:50:00'),
(71, 46, '16:50:00'),
(171, 47, '14:51:00'),
(171, 47, '15:51:00'),
(171, 47, '16:51:00'),
(171, 48, '14:25:00'),
(171, 48, '15:24:00'),
(171, 48, '16:24:00'),
(104, 49, '14:03:00'),
(104, 49, '15:23:00'),
(104, 49, '16:44:00'),
(171, 50, '14:54:00'),
(171, 50, '15:54:00'),
(171, 50, '16:54:00'),
(1, 52, '14:10:00'),
(1, 52, '15:10:00'),
(1, 52, '16:10:00'),
(71, 52, '13:25:00'),
(71, 52, '14:25:00'),
(71, 52, '15:25:00'),
(71, 52, '16:25:00'),
(151, 52, '14:14:00'),
(151, 52, '14:54:00'),
(151, 52, '15:34:00'),
(151, 52, '16:14:00'),
(151, 52, '16:54:00'),
(61, 53, '14:00:00'),
(61, 53, '15:12:00'),
(61, 53, '16:24:00'),
(21, 54, '15:25:00'),
(21, 54, '16:25:00'),
(21, 54, '17:25:00'),
(81, 54, '14:25:00'),
(81, 54, '15:20:00'),
(81, 54, '16:05:00'),
(81, 54, '16:50:00'),
(1, 55, '14:45:00'),
(1, 55, '15:46:00'),
(1, 55, '16:47:00'),
(181, 55, '13:37:00'),
(181, 55, '14:17:00'),
(181, 55, '14:57:00'),
(181, 55, '15:37:00'),
(181, 55, '16:17:00');

-- --------------------------------------------------------

--
-- Table structure for table `busassign`
--

CREATE TABLE IF NOT EXISTS `busassign` (
  `driverLicense` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `licensePlate` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `routeNum` int(3) NOT NULL,
  `lastMain` date NOT NULL,
  PRIMARY KEY (`driverLicense`,`licensePlate`,`routeNum`),
  KEY `vehicleinfo_bus_FK` (`licensePlate`),
  KEY `route_bus_FK` (`routeNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='A public-used vehicle that transports passengers.';

--
-- Dumping data for table `busassign`
--

INSERT INTO `busassign` (`driverLicense`, `licensePlate`, `routeNum`, `lastMain`) VALUES
('11105678', 'AAK5897', 971, '2013-11-25'),
('11205678', 'BBK5897', 951, '2013-11-25'),
('A2345678', '4LK5897', 1, '2013-11-25'),
('B2345678', '2AK5897', 21, '2013-11-25'),
('C2345678', '5LK5897', 61, '2013-11-25'),
('D2345678', '6LK5897', 71, '2013-11-25'),
('E2345678', '8LK5897', 181, '2013-11-25'),
('F2345678', '7LK5897', 45, '2013-11-25'),
('G2345678', '1LK5897', 81, '2013-11-25'),
('H2345678', '2LK5897', 104, '2013-11-25'),
('I2345678', '3LK5897', 151, '2013-11-25'),
('J2345678', '0LK5897', 171, '2013-11-25');

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE IF NOT EXISTS `driver` (
  `driverLicense` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(21) COLLATE utf8_unicode_ci NOT NULL,
  `age` int(3) NOT NULL,
  `address` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `lastQTest` date NOT NULL,
  PRIMARY KEY (`driverLicense`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='A person who operates a bus';

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`driverLicense`, `name`, `age`, `address`, `lastQTest`) VALUES
('11105678', 'Bob', 32, '115 Busy St Irvine, CA 92857', '2013-12-25'),
('11205678', 'Tom', 32, '784 Lazy St Irvine, CA 92857', '2013-12-25'),
('A2345678', 'John', 25, '758 West St, Irvine, CA 92857', '2013-12-25'),
('B2345678', 'Paul', 25, '922 Base Irvine, CA 92857', '2013-12-25'),
('C2345678', 'Mike', 25, '800 Waldo Ave Irvine, CA 92857', '2013-12-25'),
('D2345678', 'Kim', 25, '442 Main St Irvine, CA 92857', '2013-12-25'),
('E2345678', 'Susan', 25, '214 Horatio St Irvine, CA 92857', '2013-12-25'),
('F2345678', 'Gabe', 32, '456 Fake St Irvine, CA 92857', '2013-12-25'),
('G2345678', 'Wendy', 32, '146 Real Bldv Irvine, CA 92857', '2013-12-25'),
('H2345678', 'Jake', 32, '245 Common St Irvine, CA 92857', '2013-12-25'),
('I2345678', 'Randy', 32, '114 Busy St Irvine, CA 92857', '2013-12-25'),
('J2345678', 'Dan', 32, '774 Lazy St Irvine, CA 92857', '2013-12-25');

-- --------------------------------------------------------

--
-- Stand-in structure for view `driverdata`
--
CREATE TABLE IF NOT EXISTS `driverdata` (
`driverLicense` varchar(8)
,`name` varchar(21)
,`age` int(3)
,`address` varchar(32)
,`lastQTest` date
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `reportdata`
--
CREATE TABLE IF NOT EXISTS `reportdata` (
`driverLicense` varchar(8)
,`dateTime` datetime
,`reportType` enum('good','bad','concern','emergency','problem','recognition')
,`description` varchar(50)
);
-- --------------------------------------------------------

--
-- Table structure for table `route`
--

CREATE TABLE IF NOT EXISTS `route` (
  `direction` enum('north/south','west/east') COLLATE utf8_unicode_ci NOT NULL,
  `routeNum` int(3) NOT NULL,
  `isPassport` tinyint(1) NOT NULL,
  PRIMARY KEY (`routeNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='A set of stops';

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`direction`, `routeNum`, `isPassport`) VALUES
('north/south', 1, 0),
('north/south', 21, 0),
('west/east', 45, 0),
('north/south', 61, 0),
('north/south', 71, 0),
('west/east', 81, 0),
('west/east', 104, 0),
('west/east', 151, 0),
('west/east', 171, 0),
('north/south', 181, 0),
('north/south', 951, 1),
('west/east', 971, 1);

-- --------------------------------------------------------

--
-- Stand-in structure for view `routedata`
--
CREATE TABLE IF NOT EXISTS `routedata` (
`direction` enum('north/south','west/east')
,`routeNum` int(3)
,`isPassport` tinyint(1)
);
-- --------------------------------------------------------

--
-- Table structure for table `servicereport`
--

CREATE TABLE IF NOT EXISTS `servicereport` (
  `driverLicense` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `dateTime` datetime NOT NULL,
  `reportType` enum('good','bad','concern','emergency','problem','recognition') COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`driverLicense`,`dateTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='A submitted printed report from a passenger with description and/or feedback';

--
-- Dumping data for table `servicereport`
--

INSERT INTO `servicereport` (`driverLicense`, `dateTime`, `reportType`, `description`) VALUES
('A2345678', '2013-12-25 15:30:05', 'good', 'Good Driver'),
('B2345678', '2013-12-25 15:30:05', 'bad', 'Bad Driver'),
('C2345678', '2013-12-25 15:30:05', 'good', 'Good Driver'),
('D2345678', '2013-12-25 15:30:05', 'problem', 'Could not find a seat'),
('E2345678', '2013-12-25 15:30:05', 'problem', 'Could not find a seat'),
('F2345678', '2013-12-25 15:30:05', 'good', 'Good Driver'),
('G2345678', '2013-12-25 15:30:05', 'emergency', 'Driver crashed'),
('H2345678', '2013-12-25 15:30:05', 'good', 'Good Driver'),
('I2345678', '2013-12-25 15:30:05', 'concern', 'Driver was late'),
('J2345678', '2013-12-25 15:30:05', 'concern', 'Driver was late');

-- --------------------------------------------------------

--
-- Table structure for table `stop`
--

CREATE TABLE IF NOT EXISTS `stop` (
  `stopNum` int(3) NOT NULL,
  `crossStreets` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`stopNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `stop`
--

INSERT INTO `stop` (`stopNum`, `crossStreets`) VALUES
(1, '10th St. / Cherry'),
(2, '10th St. / Ximeno'),
(3, '25th St. / Santa Fe'),
(4, '4th / Golden'),
(5, '4th St. / Cherry'),
(6, '4th St. / Ximeno'),
(7, '68th Street / Cherry'),
(8, '7th St. / V.A. Hosp.'),
(9, 'Alondra / Garfield'),
(10, 'Anaheim / Atlantic'),
(11, 'Anaheim / Cherry'),
(12, 'Anaheim / LBBlvd.'),
(13, 'Anaheim / Long Beach Bl.'),
(14, 'Anaheim / Magnolia'),
(15, 'Anaheim / PCH'),
(16, 'Anaheim / Pacific'),
(17, 'Anaheim / Santa Fe'),
(18, 'Anaheim / Ximeno'),
(19, 'Anaheim Rd / Studebaker'),
(20, 'Artesia / Atlantic'),
(21, 'Artesia Station'),
(22, 'Atherton / Studebaker'),
(23, 'Atlantic / Carson'),
(24, 'Atlantic / Market'),
(25, 'Atlantic / Willow'),
(26, 'Broadway / Cherry'),
(27, 'Cal State Long Beach - LA1'),
(28, 'Carson / Cherry'),
(29, 'Carson / Orange'),
(30, 'Cherry / PCH'),
(31, 'Cherry / South'),
(32, 'Cherry / Willow'),
(33, 'Civic Center & Ibex'),
(34, 'Colorado / Nieto'),
(35, 'Easy Ave. / Willow'),
(36, 'El Dorado Park Nature Center'),
(37, 'Electric / Main S/B'),
(38, 'Fourth / Atlantic'),
(39, 'Garfield / Richfield'),
(40, 'Lakewood / Willow'),
(41, 'Long Beach Airport'),
(42, 'Long Beach Blvd. / PCH'),
(43, 'Long Beach Blvd. / Willow'),
(44, 'Norwalk / Wardlow'),
(45, 'Orange / South'),
(46, 'Orange / Willow'),
(47, 'PCH / Santa Fe'),
(48, 'PCH / Ximeno'),
(49, 'Palo Verde / Spring'),
(50, 'San Gabriel / Technology Place'),
(51, 'Transit Gallery Shelter B'),
(52, 'Transit Gallery Shelter D'),
(53, 'Transit Gallery Shelter G'),
(54, 'Transit Gallery Shelter H'),
(55, 'Wardlow Station');

-- --------------------------------------------------------

--
-- Stand-in structure for view `stopdata`
--
CREATE TABLE IF NOT EXISTS `stopdata` (
`stopNum` int(3)
,`crossStreets` varchar(32)
);
-- --------------------------------------------------------

--
-- Table structure for table `vehicleinfo`
--

CREATE TABLE IF NOT EXISTS `vehicleinfo` (
  `licensePlate` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `model` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `year` year(4) NOT NULL,
  `make` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`licensePlate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Gives the information about the vehicle including the year, make, manufacturer';

--
-- Dumping data for table `vehicleinfo`
--

INSERT INTO `vehicleinfo` (`licensePlate`, `model`, `year`, `make`) VALUES
('0LK5897', 'Honda', 2008, 'Express'),
('1LK5897', 'Honda', 2008, 'Express'),
('2AK5897', 'Honda', 2008, 'Express'),
('2LK5897', 'Honda', 2008, 'Express'),
('3LK5897', 'Honda', 2008, 'Express'),
('4LK5897', 'Honda', 2008, 'Express'),
('5LK5897', 'Honda', 2008, 'Express'),
('6LK5897', 'Honda', 2008, 'Express'),
('7LK5897', 'Honda', 2008, 'Express'),
('8LK5897', 'Honda', 2008, 'Express'),
('AAK5897', 'Honda', 2008, 'Express'),
('BBK5897', 'Honda', 2008, 'Express');

-- --------------------------------------------------------

--
-- Structure for view `driverdata`
--
DROP TABLE IF EXISTS `driverdata`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `driverdata` AS select `driver`.`driverLicense` AS `driverLicense`,`driver`.`name` AS `name`,`driver`.`age` AS `age`,`driver`.`address` AS `address`,`driver`.`lastQTest` AS `lastQTest` from `driver`;

-- --------------------------------------------------------

--
-- Structure for view `reportdata`
--
DROP TABLE IF EXISTS `reportdata`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `reportdata` AS select `servicereport`.`driverLicense` AS `driverLicense`,`servicereport`.`dateTime` AS `dateTime`,`servicereport`.`reportType` AS `reportType`,`servicereport`.`description` AS `description` from `servicereport`;

-- --------------------------------------------------------

--
-- Structure for view `routedata`
--
DROP TABLE IF EXISTS `routedata`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `routedata` AS select `route`.`direction` AS `direction`,`route`.`routeNum` AS `routeNum`,`route`.`isPassport` AS `isPassport` from `route`;

-- --------------------------------------------------------

--
-- Structure for view `stopdata`
--
DROP TABLE IF EXISTS `stopdata`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stopdata` AS select `stop`.`stopNum` AS `stopNum`,`stop`.`crossStreets` AS `crossStreets` from `stop`;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `arrivetime`
--
ALTER TABLE `arrivetime`
  ADD CONSTRAINT `route_arrivetime_FK` FOREIGN KEY (`routeNum`) REFERENCES `route` (`routeNum`),
  ADD CONSTRAINT `stop_arrivetime_FK` FOREIGN KEY (`stopNum`) REFERENCES `stop` (`stopNum`);

--
-- Constraints for table `busassign`
--
ALTER TABLE `busassign`
  ADD CONSTRAINT `driver_bus_FK` FOREIGN KEY (`driverLicense`) REFERENCES `driver` (`driverLicense`),
  ADD CONSTRAINT `route_bus_FK` FOREIGN KEY (`routeNum`) REFERENCES `route` (`routeNum`),
  ADD CONSTRAINT `vehicleinfo_bus_FK` FOREIGN KEY (`licensePlate`) REFERENCES `vehicleinfo` (`licensePlate`);

--
-- Constraints for table `servicereport`
--
ALTER TABLE `servicereport`
  ADD CONSTRAINT `driver_serviceReport_FK` FOREIGN KEY (`driverLicense`) REFERENCES `driver` (`driverLicense`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
