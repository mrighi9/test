package br.upf.ccc.fichaMedica.repository

import br.upf.ccc.fichaMedica.model.FichaMedica
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface FichaMedicaRepository: JpaRepository<FichaMedica, Long> {

    fun findBymedico(medicoFichaMedica: String, paginacao: Pageable): Page<FichaMedica>
}