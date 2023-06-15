package me.hanwook.security.firstproject.config

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager

/**
 * 다른 방법으로 설정하는 구성 방법
 */
class OtherSecurityConfig {
    fun authenticationManager(auth: AuthenticationManagerBuilder): AuthenticationManager {
        val inMemoryUserDetailsManager = InMemoryUserDetailsManager()

        val user = User.withUsername("user")
            .password("1234")
            .authorities("read")
            .build()

        inMemoryUserDetailsManager.createUser(user)

        return auth.userDetailsService(inMemoryUserDetailsManager)
            .passwordEncoder(NoOpPasswordEncoder.getInstance())
            .and().build()
    }
}