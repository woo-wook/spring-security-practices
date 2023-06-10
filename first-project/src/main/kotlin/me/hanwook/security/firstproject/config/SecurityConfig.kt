package me.hanwook.security.firstproject.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
class SecurityConfig {

    @Bean
    fun userDetailsService() : UserDetailsService {
        val inMemoryUserDetailsManager = InMemoryUserDetailsManager()

        val user = User.withUsername("user")
            .password("1234")
            .authorities("read")
            .build()

        inMemoryUserDetailsManager.createUser(user)

        return inMemoryUserDetailsManager
    }

    @Bean
    fun passwordEncoder() : PasswordEncoder = NoOpPasswordEncoder.getInstance()
}