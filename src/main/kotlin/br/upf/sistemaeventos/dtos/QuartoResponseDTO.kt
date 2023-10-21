package br.upf.sistemaeventos.dtos

import br.upf.sistemaeventos.model.Reserva
import br.upf.sistemaeventos.model.StatusQuarto
import java.time.LocalDateTime

data class QuartoResponseDTO (
        val id: Long?,
        val nome: String,
        val dataInicio: LocalDateTime,
        val dataFim: LocalDateTime,
        val status: StatusQuarto,
        val reservas: List<Reserva>
)