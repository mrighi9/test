package br.upf.ccc.fichaMedica.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class FichaMedica(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val medico: Usuario,
    val paciente: Usuario,
    val dataMarcada: LocalDateTime,
    val descricao: String,
    val sala: Sala,
)
