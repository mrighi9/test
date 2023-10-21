package br.upf.sistemaeventos.controller

import br.upf.sistemaeventos.dtos.QuartoDTO
import br.upf.sistemaeventos.dtos.QuartoResponseDTO
import br.upf.sistemaeventos.service.QuartoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/reservas")
class QuartoController(val service: QuartoService) {

    @GetMapping
    fun listar(
        @RequestParam(required = false) nomeQuarto: String?,
        @PageableDefault(size = 10) paginacao: Pageable)
    : Page<QuartoResponseDTO> {
        return service.listar(nomeQuarto, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): QuartoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastra(@RequestBody @Valid dto: QuartoDTO,
                 uriBuilder: UriComponentsBuilder
    ): ResponseEntity<QuartoResponseDTO> {
        val quartoResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/reservas/${quartoResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(quartoResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: QuartoDTO
    ): QuartoResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}