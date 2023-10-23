package br.upf.sistemahotel.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
data class Reserva(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val dataInicio: LocalDateTime,
    val dataFim: LocalDateTime,
    @ManyToOne
    val usuario: Usuario,
    @ManyToOne
    val quarto: Quarto,
    val data: LocalDateTime = LocalDateTime.now()
)
