package com.tns.jwttoken.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.tns.jwttoken.Security.JwtAuthenticationEntryPoint;
import com.tns.jwttoken.Security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {

	@Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
               .cors(cors -> cors.disable())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/home/**").authenticated()
                		.requestMatchers("/auth/login").permitAll().requestMatchers("/auth/create-user").permitAll()
                		.anyRequest().authenticated())
        .exceptionHandling(ex-> ex.authenticationEntryPoint(point))
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
                                                         //stateless : don't store in server that why we use stateless
        http.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);
              
        return http.build();
    }
    
   
    
    
    @Bean
    public DaoAuthenticationProvider doDaoAuthenticationProvider() {
    DaoAuthenticationProvider Provider = new DaoAuthenticationProvider();
     Provider.setUserDetailsService(userDetailsService);
     Provider.setPasswordEncoder(passwordEncoder);
     return Provider;
    }
    
   
}
