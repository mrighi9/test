package br.upf.ccc.fichaMedica.dtos

import java.time.LocalDateTime

data class ErrorResponseDTO (
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val tipoUsuario: Int,
    val error: String,
    val massage: String,
    val path: String
)