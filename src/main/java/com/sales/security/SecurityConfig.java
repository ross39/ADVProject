package com.sales.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Override
	  public void configure(HttpSecurity httpSecurity) throws Exception
	  {
	    httpSecurity.authorizeRequests()
	     .antMatchers("/addShip", "/addShippingCompany", "/addOrder")  // Add security prompt to the following pages
	     .hasRole("USER") // Set the role to be user for the following pages
	     .and()
	     .formLogin(); // Create a login form for the user to enter their username and passwrod
	  }
	  
	  @Autowired
	  public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception
	  {
		  // Set username to 'user' and password to 'user' for any roles with 'USER'
		  authentication.inMemoryAuthentication().withUser("user").password("user").roles("USER");
	  }
}