package br.upf.ccc.fichaMedica.service

import br.upf.ccc.fichaMedica.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

class AuthorizationService {
    @Service
    class AuthorizationService(
        val repository: UsuarioRepository
    ) : UserDetailsService {
        override fun loadUserByUsername(email: String) =
            repository.findByEmail(email)
    }
}