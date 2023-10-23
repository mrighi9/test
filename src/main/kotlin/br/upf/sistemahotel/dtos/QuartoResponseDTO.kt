package br.upf.sistemahotel.dtos

import br.upf.sistemahotel.model.Reserva
import br.upf.sistemahotel.model.StatusQuarto

data class QuartoResponseDTO (
        val id: Long?,
        val nome: String,
        val status: StatusQuarto,
        val reservas: List<Reserva>
)