package br.upf.ccc.fichaMedica.service

import br.upf.ccc.fichaMedica.converters.SalaConverter
import br.upf.ccc.fichaMedica.dtos.SalaDTO
import br.upf.ccc.fichaMedica.dtos.SalaResponseDTO
import br.upf.ccc.fichaMedica.exceptions.NotFoundException
import br.upf.ccc.fichaMedica.repository.SalaRepository
import org.springframework.stereotype.Service

private const val SALA_NOT_FOUND_MESSAGE = "Sala não encontrada!"


@Service
class SalaService(private val repository: SalaRepository, private val converter: SalaConverter
    ) {

    fun listar(): List<SalaResponseDTO> {
        return repository.findAll()
            .map(converter::toSalaResponseDTO)
    }

    fun buscarPorId(id: Long): SalaResponseDTO {
        val sala = repository.findById(id)
            .orElseThrow { NotFoundException( SALA_NOT_FOUND_MESSAGE) }
        return converter.toSalaResponseDTO(sala)
    }

    fun cadastrar(dto: SalaDTO): SalaResponseDTO {
        return converter.toSalaResponseDTO(
            repository.save(converter.toSala(dto))
        )
    }

    fun atualizar(id: Long, dto: SalaDTO):SalaResponseDTO {
        val sala = repository.findById(id)
            .orElseThrow { NotFoundException(SALA_NOT_FOUND_MESSAGE) }
            .copy(
                numero = dto.numero,
                bloco = dto.bloco
            )
        return converter.toSalaResponseDTO(repository.save(sala))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }


}
