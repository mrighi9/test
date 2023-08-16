package br.upf.sistemaeventos.dtos

import br.upf.sistemaeventos.model.Inscricao
import br.upf.sistemaeventos.model.StatusEvento
import java.time.LocalDate
import java.time.LocalDateTime

data class EventoResponseDTO (
    val id: Long?,
    val nome: String,
    val data: LocalDate,
    val dataInicioInsc: LocalDateTime,
    val dataFimInsc: LocalDateTime,
    val descricao: String,
    val status: StatusEvento,
    val inscritos: List<Inscricao>
)