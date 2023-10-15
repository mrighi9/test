package br.upf.ccc.fichaMedica.dtos

import br.upf.ccc.fichaMedica.model.TipoUsuario
import jakarta.validation.constraints.NotEmpty

data class UsuarioDTO(
    @field:NotEmpty(message = "Usuario sempre deve ser identificado")
    val nome: String,
    @field:NotEmpty(message = "Usuario sempre deve ter uma localidade")
    val cidade: String,
    @field:NotEmpty(message = "Usuario sempre deve ter um numero para contato")
    val telefone: String,
    @field:NotEmpty(message = "Identificacao para suas permissoes")
    val tipoUsuario: TipoUsuario,
    val senha: String,
    val email: String
)
