package br.upf.ccc.fichaMedica.repository

import br.upf.ccc.fichaMedica.model.Sala
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SalaRepository: JpaRepository<Sala,Long>