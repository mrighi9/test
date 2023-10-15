package br.upf.ccc.fichaMedica.dtos

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class SalaDTO(
    @field:NotNull(message = "Sala deve ter um número")
    val numero: Int,
    @field:NotEmpty(message = "Sala deve ter um bloco")
    val bloco: String,
)
