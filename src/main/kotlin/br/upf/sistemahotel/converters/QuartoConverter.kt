package br.upf.sistemahotel.converters

import br.upf.sistemahotel.dtos.QuartoDTO
import br.upf.sistemahotel.dtos.QuartoResponseDTO
import br.upf.sistemahotel.model.Quarto
import org.springframework.stereotype.Component

@Component
class QuartoConverter {
    fun toQuarto(dto: QuartoDTO): Quarto {
        return Quarto(
            nome = dto.nome,
            status = dto.status,
            reservas = listOf()
        )
    }

    fun toQuartoResponseDTO(quarto: Quarto): QuartoResponseDTO {
        return QuartoResponseDTO(
            id = quarto.id,
            nome = quarto.nome,
            status = quarto.status,
            reservas = quarto.reservas
        )
    }
}