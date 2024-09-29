package co.gov.archivo.indicadores.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired
  JwtAutenticationFilter jwtAutenticationFilter;

  @Autowired
  AuthenticationProvider authProvider;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(authRequest ->
            authRequest
                .requestMatchers(HttpMethod.OPTIONS).permitAll()
                .requestMatchers("/usuario", "/parameter/**").permitAll()
                .requestMatchers("/usuario/listar").authenticated()                
                .anyRequest()
                .authenticated()
        )
        .sessionManagement(sessionManager ->
            sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authenticationProvider(authProvider)
        .addFilterBefore(jwtAutenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
  }
  
}
