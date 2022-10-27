package employeeManagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import employeeManagement.serviceImpl.UserServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setPasswordEncoder(passwordEncoder());
		authProvider.setUserDetailsService(userDetailsService());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/h2-console/**").permitAll()
			.antMatchers("/roles/**", "/users/**").hasAuthority("OWNER")
			.antMatchers(HttpMethod.POST, "/employees").hasAnyAuthority("OWNER", "ADMIN")
			.antMatchers(HttpMethod.DELETE, "/employees/{employeeId}").hasAnyAuthority("OWNER", "ADMIN")
			.antMatchers(HttpMethod.PUT, "/employees").hasAnyAuthority("OWNER", "ADMIN", "USER")
			.antMatchers(HttpMethod.GET, "/", "/employees", "/employees/{employeeId}", "/employees/sort").hasAnyAuthority("OWNER", "ADMIN", "USER")
			.anyRequest().authenticated()
			.and().httpBasic()
			.and().cors().and().csrf().disable();
	}
}