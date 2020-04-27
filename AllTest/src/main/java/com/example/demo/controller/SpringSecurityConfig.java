package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    // Create 2 users for demo
//	using basic authentication
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		List<UserDetails> users=new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder().username("sai").password("marella").roles("USER").build());
//		return new InMemoryUserDetailsManager(users);
//	}
	
	
//	using database authentication
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Bean
//	public AuthenticationProvider authProvider() {
//		DaoAuthenticationProvider daoProvider=new DaoAuthenticationProvider();
//		daoProvider.setUserDetailsService(userDetailsService);
//		daoProvider.setPasswordEncoder(new BCryptPasswordEncoder());
//		return daoProvider;
//	}
//	
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception{
//		http
//		.csrf().disable()
//		.authorizeRequests().antMatchers("/login").permitAll()
//		.anyRequest().authenticated()
//		.and()
//		.formLogin()
//		.and()
//		.logout().invalidateHttpSession(true)
//		.clearAuthentication(true);
//		
//	}
	
	
	// Oauth2 authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.csrf().disable()
		.authorizeRequests().antMatchers("/login").permitAll()
		.anyRequest().authenticated(); 
	}	
}