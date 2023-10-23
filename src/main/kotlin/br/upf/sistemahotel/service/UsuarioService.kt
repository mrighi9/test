package br.upf.sistemahotel.service

import br.upf.sistemahotel.converters.UsuarioConverter
import br.upf.sistemahotel.dtos.UsuarioDTO
import br.upf.sistemahotel.dtos.UsuarioResponseDTO
import br.upf.sistemahotel.exceptions.NotFoundException
import br.upf.sistemahotel.repository.UsuarioRepository
import org.springframework.stereotype.Service

private const val USUARIO_NOT_FOUND_MESSAGE = "Usuário não encontrado!"

@Service
class UsuarioService(
    private val repository: UsuarioRepository,
    private val converter: UsuarioConverter
) {
    fun listar(): List<UsuarioResponseDTO> {
        return repository.findAll()
            .map(converter::toUsuarioResponseDTO)
    }

    fun buscarPorId(id: Long): UsuarioResponseDTO {
        val usuario = repository.findById(id)
            .orElseThrow { NotFoundException(USUARIO_NOT_FOUND_MESSAGE) }
        return converter.toUsuarioResponseDTO(usuario)
    }

    fun cadastrar(dto: UsuarioDTO): UsuarioResponseDTO {
        return converter.toUsuarioResponseDTO(
            repository.save(converter.toUsuario(dto)))
    }

    fun atualizar(id: Long, dto: UsuarioDTO): UsuarioResponseDTO {
        val usuario = repository.findById(id)
            .orElseThrow { NotFoundException(USUARIO_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                cidade = dto.cidade,
                telefone = dto.telefone
            )
        return converter.toUsuarioResponseDTO(repository.save(usuario))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

}
