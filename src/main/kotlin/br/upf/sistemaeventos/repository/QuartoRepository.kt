package br.upf.sistemaeventos.repository

import br.upf.sistemaeventos.model.Quarto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuartoRepository: JpaRepository<Quarto, Long> {

    fun findByNome(nomeQuarto: String, paginacao: Pageable): Page<Quarto>
}