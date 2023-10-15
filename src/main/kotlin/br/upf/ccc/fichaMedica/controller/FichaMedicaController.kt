package br.upf.ccc.fichaMedica.controller

import br.upf.ccc.fichaMedica.dtos.FichaMedicaDTO
import br.upf.ccc.fichaMedica.dtos.FichaMedicaResponseDTO
import br.upf.ccc.fichaMedica.model.FichaMedica
import br.upf.ccc.fichaMedica.service.FichaMedicaService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
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
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault

@RestController
@RequestMapping ("/fichamedica")
class FichaMedicaController(val service: FichaMedicaService) {


    @GetMapping
    fun listar(
        @RequestParam(required = false) medicoFichaMedica: String?,
        @PageableDefault(size = 10) paginacao: Pageable)
            : Page<FichaMedicaResponseDTO> {
        return service.listar(medicoFichaMedica, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): FichaMedicaResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastra(@RequestBody @Valid dto: FichaMedicaDTO,
                 uriBuilder: UriComponentsBuilder
    ): ResponseEntity<FichaMedicaResponseDTO> {
        val fichaMedicaResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/fichamedica/${fichaMedicaResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(fichaMedicaResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: FichaMedicaDTO): FichaMedicaResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }

}