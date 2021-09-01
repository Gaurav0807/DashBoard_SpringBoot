package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	
	@Autowired
	private UserService userService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	auth.authenticationProvider(authenticationProvider());
		
	}
	
	@Autowired
	private DataSource dataSource; 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
		.antMatchers(
				"/register**",
				"/js/**",
				"/css/**",
				"/img/**",
				"/forget",
				"/reset").permitAll()
		.anyRequest().authenticated()
		.and()
		.rememberMe().userDetailsService(userService)//RememberMeConfigurer
		//.rememberMe().tokenRepository(persistentTokenRepository())
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout"); //diirect to login page with logout message  */
		
		
//		  http.authorizeRequests()
//	       // .antMatchers("/admin/**").hasRole("ADMIN") //for admin
//	        
//		   //user roles
//	        //.antMatchers("/**").permitAll()
//	        .antMatchers("/user/**").hasAuthority("USER")
//	        //.and()
//	        //.exceptionHandling().accessDeniedHandler(null);
//	        .and().formLogin()
//	     
//	        .loginPage("/signin")
//	        .loginProcessingUrl("/dologin")
//	        .defaultSuccessUrl("/user/dashboard")
//	        .and().csrf().disable();
		
		
		
		
	}
	
	
//	@Bean
//	public PersistentTokenRepository persistentTokenRepository()
//	{
//		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
//		db.setDataSource(dataSource);
//		return db;
//	}


}
