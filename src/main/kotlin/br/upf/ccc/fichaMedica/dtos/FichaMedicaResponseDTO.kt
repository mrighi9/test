package br.upf.ccc.fichaMedica.dtos

import br.upf.ccc.fichaMedica.model.Sala
import br.upf.ccc.fichaMedica.model.Usuario
import java.time.LocalDateTime

data class FichaMedicaResponseDTO(
    val id: Long?,
    val medico: Usuario,
    val paciente: Usuario,
    val dataMarcada: LocalDateTime,
    val descricao: String,
    val sala: Sala
)
