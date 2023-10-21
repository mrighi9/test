package br.upf.sistemaeventos.repository

import br.upf.sistemaeventos.model.Reserva
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReservaRepository: JpaRepository<Reserva, Long> {
}