package br.upf.ccc.fichaMedica.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val cidade: String,
    val telefone: String,
    @Enumerated(value = EnumType.STRING)
    val tipoUsuario: TipoUsuario,
    @Enumerated(value = EnumType.STRING)
    val role: UserRole = UserRole.USER,
    val senha: String,
    val email: String,
): UserDetails {
    override fun getAuthorities(): MutableList<SimpleGrantedAuthority> =
        if (role == UserRole.ADMIN) mutableListOf(
            SimpleGrantedAuthority("ROLE_ADMIN"),
            SimpleGrantedAuthority("ROLE_USER")
        )
        else mutableListOf(SimpleGrantedAuthority("ROLE_USER"))


    override fun getPassword() = senha

    override fun getUsername() = email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}