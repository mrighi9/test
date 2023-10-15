package br.upf.ccc.fichaMedica.converters

import br.upf.ccc.fichaMedica.dtos.SalaDTO
import br.upf.ccc.fichaMedica.dtos.SalaResponseDTO
import br.upf.ccc.fichaMedica.model.Sala
import org.springframework.stereotype.Component

@Component
class SalaConverter {
    fun toSala(dto: SalaDTO): Sala {
        return Sala(
            numero = dto.numero,
            bloco = dto.bloco
        )
    }

    fun toSalaResponseDTO(sala: Sala): SalaResponseDTO {
        return SalaResponseDTO(
            id = sala.id,
            numero =  sala.numero,
            bloco = sala.bloco
        )
    }
}