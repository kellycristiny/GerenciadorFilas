CREATE DATABASE gerenciador_fila;

USE gerenciador_fila;

CREATE TABLE senhas(id INTEGER PRIMARY KEY AUTO_INCREMENT, codigo VARCHAR(5), chegada DATE, atendimento DATE, status_atendimento VARCHAR(20), tipo_senha VARCHAR(20));

select * from senhas;