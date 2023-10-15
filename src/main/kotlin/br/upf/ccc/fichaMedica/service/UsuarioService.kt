package br.upf.ccc.fichaMedica.service

import br.upf.ccc.fichaMedica.converters.UsuarioConverter
import br.upf.ccc.fichaMedica.dtos.UsuarioResponseDTO
import br.upf.ccc.fichaMedica.dtos.UsuarioDTO
import br.upf.ccc.fichaMedica.exceptions.NotFoundException
import br.upf.ccc.fichaMedica.repository.UsuarioRepository
import org.springframework.stereotype.Service

private const val USUARIO_NOT_FOUND_MESSAGE = "Usuário não encontrado!"

@Service
class UsuarioService(
    private val repository: UsuarioRepository,
    private val converter: UsuarioConverter,

) {


    fun listar(): List<UsuarioResponseDTO>{
        return repository.findAll()
            .map(converter::toUsuarioResponseDTO)
    }

     fun buscarPorId(id: Long): UsuarioResponseDTO {
        val usuario = repository.findById(id)
            .orElseThrow { NotFoundException( USUARIO_NOT_FOUND_MESSAGE) }
        return converter.toUsuarioResponseDTO(usuario)
    }

    fun cadastrar(dto: UsuarioDTO): UsuarioResponseDTO {
        return converter.toUsuarioResponseDTO(repository.save(converter.toUsuario(dto)))
    }

    fun atualizar(id: Long, dto: UsuarioDTO): UsuarioResponseDTO {
        val usuario = repository.findById(id)
            .orElseThrow { NotFoundException( USUARIO_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                cidade = dto.cidade,
                telefone = dto.telefone,
                tipoUsuario = dto.tipoUsuario
            )
        return converter.toUsuarioResponseDTO(repository.save(usuario))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}