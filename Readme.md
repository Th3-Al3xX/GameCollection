Este é um projeto de finalização de curso da parceria Atos - UFN 2021

Nome do Projeto: Game Collection

Instuito: Cadastro de jogos pessoais no estilo de um inventtário

Tecnologias utilizadas: JSP, Servlet, JDBC, Bootstrap

Servidor utilizado: Apache Tomcat 7.0.50

IDE utilizada: Eclipse IDE - Version: 2021-09 (4.21.0) - Build id: 20210910-1417

Banco de Dados: MySQL 8.0.13

==============================================================================

Nome do banco: game-collection
Tabela: gamesdb

Estrutura:
+------------+--------------+------+-----+---------+----------------+
| Field      | Type         | Null | Key | Default | Extra          |
+------------+--------------+------+-----+---------+----------------+
| id         | int          | NO   | PRI | NULL    | auto_increment |
| nome       | varchar(100) | NO   |     | NULL    |                |
| desenv     | varchar(100) | YES  |     | NULL    |                |
| estilo     | varchar(100) | NO   |     | NULL    |                |
| plataforma | varchar(100) | NO   |     | NULL    |                |
+------------+--------------+------+-----+---------+----------------+

Script:
CREATE TABLE gamesdb (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  desenv VARCHAR(100),
  estilo VARCHAR(100) NOT NULL,
  plataforma VARCHAR(100) NOT NULL);
  
==============================================================================




Alexsandro de Souza Eusebio
============================
ATOS / UFN - 14/12/2021