package br.upf.sistemaeventos.converters

import br.upf.sistemaeventos.dtos.QuartoDTO
import br.upf.sistemaeventos.dtos.QuartoResponseDTO
import br.upf.sistemaeventos.model.Quarto
import org.springframework.stereotype.Component

@Component
class QuartoConverter {
    fun toQuarto(dto: QuartoDTO): Quarto {
        return Quarto(
            nome = dto.nome,
            dataInicio = dto.dataInicio,
            dataFim = dto.dataFim,
            status = dto.status,
            reservas = listOf()
        )
    }

    fun toQuartoResponseDTO(quarto: Quarto): QuartoResponseDTO {
        return QuartoResponseDTO(
            id = quarto.id,
            nome = quarto.nome,
            dataInicio = quarto.dataInicio,
            dataFim = quarto.dataFim,
            status = quarto.status,
            reservas = quarto.reservas
        )
    }
}