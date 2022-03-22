package com.evento.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.evento.enums.Role;
import com.evento.service.UserDetailsServiceImpl;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		       .antMatchers("/resources/**","/css/**","/img/**", "/js/**","/error/**").permitAll()
		       .antMatchers("/adm/**").hasAuthority(Role.ADMIN.getNome())
		       .anyRequest().authenticated()
		       .and()
		      .formLogin()
		        .loginPage("/login")
		        .defaultSuccessUrl("/home")
		        .permitAll()
		        .and()
		      .logout()
		        .permitAll();	

//        .antMatchers( "/", "/logout**" ).permitAll()
//        .antMatchers( "/login" ).authenticated()
//        .antMatchers( "/crianca/**" ).hasRole("USER")
//        .antMatchers( "/gerencia/**" ).hasRole("ADMIN")	
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() { 
	        return new BCryptPasswordEncoder();     
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
	}
	 
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/h2/**");   
    }

	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService)
//		    .passwordEncoder(getPasswordEncoder());
//	}
//	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return new BCryptPasswordEncoder(12);
//	}
	
		
	}


