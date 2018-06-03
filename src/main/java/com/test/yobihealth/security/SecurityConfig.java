package com.test.yobihealth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder pa ;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		/*auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
		.withUser("admin").password("admin").roles("ADMIN","USER")
		.and()
		.withUser("user").password("user").roles("USER");*/
	
		auth.userDetailsService(userDetailsService).passwordEncoder(pa);
		
	}
	 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.csrf().disable();
		//http.formLogin();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/login/**","/register/**").permitAll();
		http.authorizeRequests().antMatchers("/health/**","/healths/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/file").permitAll();
		//http.authorizeRequests().antMatchers(HttpMethod.POST,"/health/**").hasAuthority("ADMIN");
		//http.authorizeRequests().antMatchers(HttpMethod.POST,"/healths/**").hasAuthority("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		http.addFilter(new JWTAthenticationFilter(authenticationManager())); 
		http.addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);

		
		
	}
	

}
