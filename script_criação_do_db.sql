CREATE DATABASE `game-collection`;

USE `game-collection`;

CREATE TABLE `gamesdb` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nome` VARCHAR(100) NOT NULL,
  `desenv` VARCHAR(100),
  `estilo` VARCHAR(100) NOT NULL,
  `plataforma` VARCHAR(100) NOT NULL);