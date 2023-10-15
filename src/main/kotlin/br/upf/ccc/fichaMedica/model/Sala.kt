package br.upf.ccc.fichaMedica.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Sala(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?= null,
    val numero: Int,
    val bloco: String,
)
