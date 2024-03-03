/*
 * package com.scb.web;
 * 
 * 
 * import org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class WebSecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * System.out.println("in WebSecurityConfig --configure method"+http); http
 * .authorizeRequests() .antMatchers("/home").authenticated() // Require
 * authentication for accessing the home page .anyRequest().permitAll() // Allow
 * access to other endpoints without authentication .and() .formLogin()
 * .loginPage("/") //.loginProcessingUrl("/api/login") // Login form submission
 * URL .defaultSuccessUrl("/home") // Redirect to home page after successful
 * login .permitAll() .and() .logout() .permitAll() .and() .exceptionHandling()
 * .accessDeniedPage("/login"); // Redirect to login page for access denied
 * (unauthorized) requests
 * System.out.println("in WebSecurityConfig --configure method end"); } }
 */