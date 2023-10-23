package br.upf.sistemahotel.repository

import br.upf.sistemahotel.model.Reserva
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReservaRepository: JpaRepository<Reserva, Long> {
}