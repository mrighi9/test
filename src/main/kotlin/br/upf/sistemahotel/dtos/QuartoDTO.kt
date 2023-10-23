package br.upf.sistemahotel.dtos

import br.upf.sistemahotel.model.StatusQuarto
import jakarta.validation.constraints.NotBlank

data class QuartoDTO(
    @field:NotBlank(message = "Quarto sempre deve ter um nome")
    val nome: String,
    val status: StatusQuarto
)