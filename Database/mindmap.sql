-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Generation Time: Oct 31, 2013 at 03:00 PM
-- Server version: 5.0.51
-- PHP Version: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Database: `quanlymindmao`
-- 

-- --------------------------------------------------------

-- 
-- Table structure for table `mindmap`
-- 

CREATE TABLE `mindmap` (
  `id` int(11) NOT NULL,
  `mX` float NOT NULL,
  `mY` float NOT NULL,
  `text` varchar(20) character set utf8 collate utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table `mindmap`
-- 

