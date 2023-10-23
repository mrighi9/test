CREATE TABLE `quarto` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `nome` varchar(255) NOT NULL,
 `status` enum('VAGO','RESERVADO') DEFAULT NULL
);