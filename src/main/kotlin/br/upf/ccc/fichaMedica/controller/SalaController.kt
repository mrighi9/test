package br.upf.ccc.fichaMedica.controller

import br.upf.ccc.fichaMedica.dtos.SalaDTO
import br.upf.ccc.fichaMedica.dtos.SalaResponseDTO
import br.upf.ccc.fichaMedica.service.SalaService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/salas")
class SalaController(val service: SalaService) {

    @GetMapping
    fun listar(): List<SalaResponseDTO>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): SalaResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastra(@RequestBody @Valid dto: SalaDTO,
                 uriBuilder: UriComponentsBuilder
    ): ResponseEntity<SalaResponseDTO>{
        val salaResponse =  service.cadastrar(dto)
        val uri =   uriBuilder.path("/salas/$salaResponse.id")
            .build().toUri()
        return ResponseEntity.created(uri).body(salaResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: SalaDTO
    ): SalaResponseDTO {
       return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}