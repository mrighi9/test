CREATE TABLE `reserva` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `data` datetime(6) NOT NULL,
 `quarto_id` bigint NOT NULL,
 `usuario_id` bigint NOT NULL,
 FOREIGN KEY (`quarto_id`) REFERENCES `quarto` (`id`),
 FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
);