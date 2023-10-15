package br.upf.ccc.fichaMedica.dtos

import br.upf.ccc.fichaMedica.model.Sala
import br.upf.ccc.fichaMedica.model.Usuario
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

data class FichaMedicaDTO(
    //val id: Long? = null,
    @field:NotEmpty(message = "Deve haver um medico responsavel")
    val medico: Usuario,
    @field:NotEmpty(message = "Deve haver um paciente")
    val paciente: Usuario,
    @field:NotNull(message = "A consulta deve haver uma data marcada")
    val dataMarcada: LocalDateTime,
    val descricao: String,
    @field:NotNull(message = "A consulta deve ter uma sala marcada")
    val sala: Sala,
)
