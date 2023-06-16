package me.hanwook.security.firstproject.config

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class CustomAuthenticationProvider: AuthenticationProvider {

    override fun authenticate(authentication: Authentication): Authentication {
        val userId = authentication.name
        val password = authentication.credentials.toString()

        if (userId == "john" && password == "12345") { // UserDetailsService와 PasswordEncoder를 대신한다.
            return UsernamePasswordAuthenticationToken(userId, password, arrayListOf())
        }

        throw AuthenticationCredentialsNotFoundException("Error in authentication!")
    }

    override fun supports(authentication: Class<*>): Boolean {
        return UsernamePasswordAuthenticationToken::class.java
            .isAssignableFrom(authentication)
    }
}