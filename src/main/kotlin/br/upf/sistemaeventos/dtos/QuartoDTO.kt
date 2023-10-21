package br.upf.sistemaeventos.dtos

import br.upf.sistemaeventos.model.StatusQuarto
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

data class QuartoDTO(
    @field:NotBlank(message = "Quarto sempre deve ter um nome")
    val nome: String,
    @field:NotNull(message = "Quarto sempre deve ter uma data de inicio")
    val dataInicio: LocalDateTime,
    @field:NotNull(message = "Quarto sempre deve ter uma data de fim")
    val dataFim: LocalDateTime,
    val status: StatusQuarto
)