package br.upf.ccc.fichaMedica.controller

import br.upf.ccc.fichaMedica.dtos.UsuarioResponseDTO
import br.upf.ccc.fichaMedica.dtos.UsuarioDTO
import br.upf.ccc.fichaMedica.service.UsuarioService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/usuarios")
class UsuarioController(
    val service: UsuarioService
) {

    @GetMapping
    fun listar(): List<UsuarioResponseDTO>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): UsuarioResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastra(@RequestBody @Valid dto: UsuarioDTO,
                 uriBuilder: UriComponentsBuilder): ResponseEntity<UsuarioResponseDTO> {
        val usuarioResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/usuarios/${usuarioResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(usuarioResponse)
    }


    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: UsuarioDTO): UsuarioResponseDTO {
        return service.atualizar(id, dto)
    }


    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}