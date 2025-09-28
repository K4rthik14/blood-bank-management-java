CREATE DATABASE IF NOT EXISTS bms;

USE bms;

CREATE TABLE IF NOT EXISTS `login` (
  `uname` varchar(50) NOT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uname`)
);

INSERT INTO `login` (`uname`, `pwd`) VALUES
('admin', 'admin123');


CREATE TABLE IF NOT EXISTS `donor` (
  `roll_number` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `blood_group` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`roll_number`)
);