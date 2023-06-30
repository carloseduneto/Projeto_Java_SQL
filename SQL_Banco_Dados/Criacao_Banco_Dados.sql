CREATE DATABASE SistemaCartao2;

CREATE TABLE titular(
idTitular int PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100),
cpf VARCHAR(15)
);

CREATE TABLE cartao(
idCartao INT PRIMARY KEY AUTO_INCREMENT,
numero VARCHAR(25),
validade DATE,
nome VARCHAR(100),
limite DOUBLE,
idTitular INT,
CONSTRAINT fkIdTitular FOREIGN KEY (idTitular) REFERENCES titular(idTitular)
);


CREATE TABLE transacao(
idTransacao INT PRIMARY KEY AUTO_INCREMENT,
valor FLOAT,
estabelecimento VARCHAR(100),
idCartao INT, 
CONSTRAINT fkIdCartao FOREIGN KEY (idCartao) REFERENCES cartao (idCartao)
);

INSERT INTO titular (nome, cpf) VALUES
('João da Silva', '123.456.789-00'),
('Maria Santos', '987.654.321-00'),
('Carlos Oliveira', '111.222.333-44'),
('Ana Costa', '555.666.777-88'),
('Pedro Souza', '999.888.777-66'),
('Mariana Pereira', '333.444.555-66'),
('Paulo Gomes', '777.888.999-00'),
('Camila Silva', '222.111.333-55'),
('Rafaela Castro', '444.555.666-99');

INSERT INTO cartao (numero, validade, nome, limite, idTitular) VALUES
('1234567890123456', '2025-01-01', 'João da Silva', 1000.00, 1),
('9876543210987654', '2024-12-01', 'Maria Santos', 1500.00, 2),
('1111222233334444', '2023-06-01', 'Carlos Oliveira', 2000.00, 3),
('5555666677778888', '2026-03-01', 'Ana Costa', 2500.00, 4),
('9999888877776666', '2025-07-01', 'Pedro Souza', 3000.00, 5),
('3333444455556666', '2024-09-01', 'Mariana Pereira', 3500.00, 6),
('7777888899990000', '2025-11-01', 'Paulo Gomes', 4000.00, 7),
('2221113335556666', '2026-02-01', 'Camila Silva', 4500.00, 8),
('4445556669990000', '2024-08-01', 'Rafaela Castro', 5000.00, 9);

INSERT INTO transacao (valor, estabelecimento, idCartao) VALUES
(100.00, 'Loja A', 1),
(200.00, 'Loja B', 2),
(300.00, 'Loja C', 3),
(400.00, 'Loja D', 4),
(500.00, 'Loja E', 5),
(600.00, 'Loja F', 6),
(700.00, 'Loja G', 7),
(800.00, 'Loja H', 8),
(900.00, 'Loja I', 9);
