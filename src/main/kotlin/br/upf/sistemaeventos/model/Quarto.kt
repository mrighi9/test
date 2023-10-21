package br.upf.sistemaeventos.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.time.LocalDateTime

@Entity
data class Quarto(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val dataInicio: LocalDateTime,
    val dataFim: LocalDateTime,
    @Enumerated(value = EnumType.STRING)
    val status: StatusQuarto,
    @OneToMany(mappedBy = "quarto")
    val reservas: List<Reserva> = listOf()
)
