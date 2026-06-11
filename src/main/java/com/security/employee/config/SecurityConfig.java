package com.security.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	// csrf -> cross site request forgery

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http.csrf(c -> c.disable())

				.authorizeHttpRequests(auth -> auth

						.requestMatchers("/login").permitAll()

						.requestMatchers("/public/**").permitAll()

						.requestMatchers("/dashboard").authenticated()

						.requestMatchers("/employees").hasAnyRole("USER", "ADMIN")

						.requestMatchers("/admin", "/admin/**").hasRole("ADMIN")

						.requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")

						.anyRequest().authenticated())

				.httpBasic(Customizer.withDefaults())

				.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/dashboard", true).permitAll())

				.logout(logout -> logout.logoutSuccessUrl("/login?logout").permitAll())

				.build();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {

		return new BCryptPasswordEncoder();
	}
}