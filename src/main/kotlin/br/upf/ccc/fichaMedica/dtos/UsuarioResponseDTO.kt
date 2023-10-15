package br.upf.ccc.fichaMedica.dtos

import br.upf.ccc.fichaMedica.model.TipoUsuario

data class UsuarioResponseDTO(
    val id: Long?,
    val nome: String,
    val cidade: String,
    val telefone: String,
    val tipoUsuario: TipoUsuario,
    val senha: String,
    val email: String
)
