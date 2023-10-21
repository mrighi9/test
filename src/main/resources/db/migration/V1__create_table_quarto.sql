CREATE TABLE `quarto` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `data_fim` datetime(6) NOT NULL,
 `data_inicio` datetime(6) NOT NULL,
 `nome` varchar(255) NOT NULL,
 `status` enum('VAGO','RESERVADO') DEFAULT NULL
);