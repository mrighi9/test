package br.upf.sistemaeventos.dtos

import br.upf.sistemaeventos.model.StatusEvento
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate
import java.time.LocalDateTime

data class EventoDTO(
    @field:NotBlank(message = "Evento sempre deve ter um nome")
    val nome: String,
    @field:NotNull(message = "Evento sempre deve ter uma data")
    val data: LocalDate,
    @field:NotNull(message = "Evento sempre deve ter uma data de inicio das inscrições")
    val dataInicioInsc: LocalDateTime,
    @field:NotNull(message = "Evento sempre deve ter uma data de fim das inscrições")
    val dataFimInsc: LocalDateTime,
    val descricao: String,
    val status: StatusEvento
)