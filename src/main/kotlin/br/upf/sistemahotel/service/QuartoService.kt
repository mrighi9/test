package br.upf.sistemahotel.service

import br.upf.sistemahotel.converters.QuartoConverter
import br.upf.sistemahotel.dtos.QuartoDTO
import br.upf.sistemahotel.dtos.QuartoResponseDTO
import br.upf.sistemahotel.exceptions.NotFoundException
import br.upf.sistemahotel.repository.QuartoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private const val QUARTO_NOT_FOUND_MESSAGE = "Quarto não encontrado!"

@Service
class QuartoService(
        private val repository: QuartoRepository,
        private val converter: QuartoConverter
) {

    fun listar(
        nomeQuarto: String?,
        paginacao: Pageable): Page<QuartoResponseDTO> {
        val quartos = if (nomeQuarto == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByNome(nomeQuarto, paginacao)
        }
        return quartos
            .map(converter::toQuartoResponseDTO)
    }

    fun buscarPorId(id: Long): QuartoResponseDTO {
        val quarto = repository.findById(id)
            .orElseThrow { NotFoundException(QUARTO_NOT_FOUND_MESSAGE) }
        return converter.toQuartoResponseDTO(quarto)
    }

    fun cadastrar(dto: QuartoDTO): QuartoResponseDTO {
        return converter.toQuartoResponseDTO(
            repository.save(converter.toQuarto(dto))
        )
    }

    fun atualizar(id: Long, dto: QuartoDTO): QuartoResponseDTO {
        val quarto = repository.findById(id)
            .orElseThrow { NotFoundException(QUARTO_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                status = dto.status
            )
        return converter.toQuartoResponseDTO(repository.save(quarto))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}