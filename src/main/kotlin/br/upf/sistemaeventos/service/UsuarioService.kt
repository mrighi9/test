package br.upf.sistemaeventos.service

import br.upf.sistemaeventos.converters.UsuarioConverter
import br.upf.sistemaeventos.dtos.UsuarioDTO
import br.upf.sistemaeventos.dtos.UsuarioResponseDTO
import br.upf.sistemaeventos.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService (private val repository: UsuarioRepository,
                      private val converter: UsuarioConverter
) {
    fun listar(): List<UsuarioResponseDTO> {
        TODO("Not yet implemented")
    }

    fun buscarPorId(id: Long): UsuarioResponseDTO {
        TODO("Not yet implemented")
    }

    fun cadastrar(dto: UsuarioDTO): UsuarioResponseDTO {
        TODO("Not yet implemented")
    }

    fun atualizar(id: Long, dto: UsuarioDTO): UsuarioResponseDTO {
        TODO("Not yet implemented")
    }

    fun deletar(id: Long) {
        TODO("Not yet implemented")
    }

}
