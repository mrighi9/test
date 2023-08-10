package br.upf.sistemaeventos.model

import java.time.LocalDate
import java.time.LocalDateTime

data class Evento(
    val id: Long? = null,
    val nome: String,
    val data: LocalDate,
    val dataInicioInsc: LocalDateTime,
    val dataFimInsc: LocalDateTime,
    val descricao: String,
    val status: StatusEvento,
    val inscritos: List<Inscricao>
)
