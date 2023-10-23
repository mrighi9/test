package br.upf.sistemahotel.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class Quarto(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    @Enumerated(value = EnumType.STRING)
    val status: StatusQuarto,
    @OneToMany(mappedBy = "quarto")
    val reservas: List<Reserva> = listOf()
)
