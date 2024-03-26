package com.ever.suinocutura.conf.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	SecurityFilter securityFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/swagger-ui").permitAll()
						.requestMatchers("/h2-console").permitAll()
						.requestMatchers("/swagger-ui/**").permitAll()
						.requestMatchers("/v3/api-docs/**").permitAll()
						.requestMatchers("/swagger-ui/index.html").permitAll()
						.requestMatchers("/v3/api-docs/swagger-config").permitAll()
						.requestMatchers(HttpMethod.POST, "/login").permitAll()
						.requestMatchers(HttpMethod.POST, "/register").permitAll()
						.requestMatchers(HttpMethod.POST, "/produtos").hasRole("ADMIN")
						.requestMatchers(HttpMethod.GET, "/produtos").hasAnyRole("ADMIN", "USER")
						.requestMatchers(HttpMethod.GET, "/produtos/{id}").hasAnyRole("ADMIN", "USER")
						.requestMatchers(HttpMethod.DELETE, "/produtos/{id}").hasRole("ADMIN")
						.requestMatchers(HttpMethod.PUT, "/produtos/{id}").hasRole("ADMIN")
						.requestMatchers(HttpMethod.POST, "/carrinho").hasAnyRole("ADMIN", "USER")
						.requestMatchers(HttpMethod.GET, "/carrinho").hasAnyRole("ADMIN", "USER")
						.requestMatchers(HttpMethod.GET, "/carrinho/{id}").hasAnyRole("ADMIN", "USER")
						.requestMatchers(HttpMethod.DELETE, "/carrinho/{id}").hasAnyRole("ADMIN", "USER")
						.requestMatchers(HttpMethod.PUT, "/carrinho/{id}").hasAnyRole("ADMIN", "USER")
						.anyRequest().authenticated()
				)
				.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
