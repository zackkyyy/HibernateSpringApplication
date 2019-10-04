-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 04, 2019 at 02:24 PM
-- Server version: 5.7.24
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `finaltaskjava`
--
CREATE DATABASE IF NOT EXISTS `finaltaskjava` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `finaltaskjava`;

-- --------------------------------------------------------

--
-- Table structure for table `character_card`
--

CREATE TABLE `character_card` (
  `id` int(11) NOT NULL,
  `character_name` varchar(255) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `character_card`
--

INSERT INTO `character_card` (`id`, `character_name`, `level`, `class_id`, `user_id`) VALUES
(1, 'Hero', 12, 2, 1),
(2, 'haeea', 123, 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `character_type`
--

CREATE TABLE `character_type` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `character_type`
--

INSERT INTO `character_type` (`id`, `name`) VALUES
(1, 'Weak'),
(2, 'Great'),
(3, 'Strategiest'),
(4, 'Warrior');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `password`, `user_name`) VALUES
(1, 'hasda', 'Zack1'),
(2, 'hasda', 'ZAZA');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `character_card`
--
ALTER TABLE `character_card`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkbd4ljw7k6pb422f2ygo6sj4g` (`class_id`),
  ADD KEY `FKh8bx4orhvscyfmn1o7t68ngg4` (`user_id`);

--
-- Indexes for table `character_type`
--
ALTER TABLE `character_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `character_card`
--
ALTER TABLE `character_card`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `character_type`
--
ALTER TABLE `character_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
