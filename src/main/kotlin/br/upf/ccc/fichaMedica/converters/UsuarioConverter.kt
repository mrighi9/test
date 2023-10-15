package br.upf.ccc.fichaMedica.converters

import br.upf.ccc.fichaMedica.dtos.UsuarioResponseDTO
import br.upf.ccc.fichaMedica.dtos.UsuarioDTO
import br.upf.ccc.fichaMedica.model.Usuario
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class UsuarioConverter {
    fun toUsuarioResponseDTO(usuario: Usuario): UsuarioResponseDTO {
        return UsuarioResponseDTO(
            id = usuario.id,
            nome = usuario.nome,
            cidade = usuario.cidade,
            telefone = usuario.telefone,
            tipoUsuario = usuario.tipoUsuario,
            senha= usuario.senha,
            email = usuario.email
        )
    }
    fun toUsuario(dto: UsuarioDTO): Usuario{
        return Usuario(
            nome = dto.nome,
            cidade = dto.cidade,
            telefone = dto.telefone,
            tipoUsuario = dto.tipoUsuario,
            senha = BCryptPasswordEncoder().encode(dto.senha),
            email = dto.email
        )
    }


}