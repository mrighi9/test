package br.upf.ccc.fichaMedica.controller

import br.upf.ccc.fichaMedica.dtos.LoginDTO
import br.upf.ccc.fichaMedica.dtos.UsuarioDTO
import br.upf.ccc.fichaMedica.model.Usuario
import br.upf.ccc.fichaMedica.service.TokenService
import br.upf.ccc.fichaMedica.service.UsuarioService
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

class AuthenticationController {
    @RestController
    @RequestMapping ("auth")
    class AuthenticationController(
        val authenticationManager : AuthenticationManager ,
        val service: UsuarioService ,
        val tokenService: TokenService) {
        @PostMapping("/login")
        fun login(@RequestBody data: LoginDTO): ResponseEntity<LoginResponseDTO>
        {
            val userPassword = UsernamePasswordAuthenticationToken(data. login, data.password)
            val auth = authenticationManager .authenticate(userPassword)
            val token = tokenService.generateToken(auth. principal as Usuario)
            return ResponseEntity.ok(LoginResponseDTO(token))
        }

        }
}