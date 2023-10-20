CREATE TABLE `sala` (
 `id` BIGINT NOT NULL AUTO_INCREMENT,
 `numero` BIGINT NOT NULL,
 `bloco` VARCHAR(255) NOT NULL,
 `fichamedica_id` BIGINT NOT NULL,
 `usuario_id` BIGINT NOT NULL,
 PRIMARY KEY (`id`),
 FOREIGN KEY (`fichamedica_id`) REFERENCES `fichamedica` (`id`),
 FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
);
