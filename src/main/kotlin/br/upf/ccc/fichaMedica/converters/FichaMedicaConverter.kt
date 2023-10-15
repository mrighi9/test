package br.upf.ccc.fichaMedica.converters

import br.upf.ccc.fichaMedica.dtos.FichaMedicaDTO
import br.upf.ccc.fichaMedica.dtos.FichaMedicaResponseDTO
import br.upf.ccc.fichaMedica.model.FichaMedica
import org.springframework.stereotype.Component

@Component
class FichaMedicaConverter {
    fun toFichaMedica(dto: FichaMedicaDTO): FichaMedica {
        return FichaMedica(
            medico = dto.medico,
            paciente = dto.paciente,
            dataMarcada = dto.dataMarcada,
            descricao = dto.descricao,
            sala = dto.sala
        )
    }

    fun toEventoResponseDTO(fichaMedica: FichaMedica): FichaMedicaResponseDTO {
        return FichaMedicaResponseDTO(
            id = fichaMedica.id,
            medico = fichaMedica.medico,
            paciente = fichaMedica.paciente,
            dataMarcada = fichaMedica.dataMarcada,
            descricao = fichaMedica.descricao,
            sala = fichaMedica.sala
        )
    }



}