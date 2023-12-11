package br.com.gid.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.cors(Customizer.withDefaults())
				.csrf(c -> c.disable())
				.authorizeHttpRequests((requests) -> requests
					.requestMatchers("/images/**", "/js/**", "/css/**", "/home", "/").permitAll()
					.anyRequest().authenticated()
				)
				.formLogin((form) -> form
					.loginPage("/login")
					.defaultSuccessUrl("/trabalhos")
					.permitAll()
				)
				.logout((logout) -> logout.permitAll())
				.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("admin")
				.password("admin")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}