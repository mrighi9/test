package br.upf.sistemaeventos.model

import java.time.LocalDateTime

data class Inscricao(
    val id: Long? = null,
    val usuario: Usuario,
    val data: LocalDateTime = LocalDateTime.now()
)
