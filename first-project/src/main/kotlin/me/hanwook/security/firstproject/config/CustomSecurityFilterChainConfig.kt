package me.hanwook.security.firstproject.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class CustomSecurityFilterChainConfig {
  @Bean
  fun filterChain(http: HttpSecurity): SecurityFilterChain =
      http.httpBasic().and()
          .authorizeHttpRequests().anyRequest()
          .permitAll().and().build() // 인증 없이 요청 가능하다.
}
