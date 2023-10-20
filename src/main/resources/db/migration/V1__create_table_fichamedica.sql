CREATE TABLE `fichamedica` (
  `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `medico` VARCHAR(255) NOT NULL,
  `paciente` VARCHAR(255) NOT NULL,
  `dataMarcada` DATE NOT NULL,
  `descricao` VARCHAR(255) DEFAULT NULL,
  `sala` BIGINT NOT NULL
);

