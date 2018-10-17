package com.interview.task.sfl.restaurant.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



  @Bean @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Bean
  public MyUserDetails getUserDetailsService(){
    return new MyUserDetails();
  }

  @Autowired
  public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    auth
            .userDetailsService(getUserDetailsService());
  }

  @Bean
  public MyCustomFilter myCustomFilter() throws Exception {
    MyCustomFilter myCustomFilter = new MyCustomFilter();
    myCustomFilter.setAuthenticationManager(super.authenticationManager());
    return myCustomFilter;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    // Disable CSRF (cross site request forgery)
    http.csrf().disable();

    // No session will be created or used by spring security
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    // Entry points
    http.authorizeRequests()
//        .antMatchers("/api/v1/users/**").permitAll()
//        .antMatchers("/api/v1/tables/**").permitAll()
//        .antMatchers("/api/v1/productsInOrder/**").permitAll()
//        .antMatchers("/api/v1/products/**").permitAll()
//        .antMatchers("api/v1/orders/**").permitAll()
        // Disallow everything else..
        .anyRequest().authenticated();




    http.addFilterBefore(myCustomFilter(), UsernamePasswordAuthenticationFilter.class);

    // Optional, if you want to test the API from a browser
    // http.httpBasic();
  }


  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(12);
  }

}
