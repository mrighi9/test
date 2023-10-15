package br.upf.ccc.fichaMedica.service

import br.upf.ccc.fichaMedica.converters.FichaMedicaConverter
import br.upf.ccc.fichaMedica.dtos.FichaMedicaDTO
import br.upf.ccc.fichaMedica.dtos.FichaMedicaResponseDTO
import br.upf.ccc.fichaMedica.exceptions.NotFoundException
import br.upf.ccc.fichaMedica.repository.FichaMedicaRepository
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import org.springframework.data.domain.Pageable


private const val FICHA_MEDICA_NOT_FOUND_MESSAGE = "Ficha medica não encontrada!"

@Service
class FichaMedicaService(private val repository: FichaMedicaRepository,
                         private val converter: FichaMedicaConverter,
    ) {

    fun listar(
        medicoFichaMedica: String?,
        paginacao: Pageable): Page<FichaMedicaResponseDTO> {
        val fichaMedica = if (medicoFichaMedica == null) {
            repository.findAll(paginacao)
        } else {
            repository.findBymedico(medicoFichaMedica, paginacao)
        }
        return fichaMedica.map(converter::toEventoResponseDTO)
    }

    fun buscarPorId(id: Long): FichaMedicaResponseDTO {
        val fichaMedica = repository.findById(id)
            .orElseThrow { NotFoundException( FICHA_MEDICA_NOT_FOUND_MESSAGE ) }
        return converter.toEventoResponseDTO(fichaMedica)
    }

    fun cadastrar(dto: FichaMedicaDTO): FichaMedicaResponseDTO {
        return converter.toEventoResponseDTO(repository.save(converter.toFichaMedica(dto)))
    }

    fun atualizar(id: Long, dto: FichaMedicaDTO): FichaMedicaResponseDTO {
        val fichaMedica = repository.findById(id)
            .orElseThrow { NotFoundException(FICHA_MEDICA_NOT_FOUND_MESSAGE) }
            .copy(
                medico = dto.medico,
                paciente = dto.paciente,
                dataMarcada = dto.dataMarcada,
                descricao = dto.descricao,
                sala = dto.sala
            )
        return converter.toEventoResponseDTO(repository.save(fichaMedica))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}