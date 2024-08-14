package com.example.__Security_in_memory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/hello-user").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/hello-admin").hasRole("ADMIN")
                        .requestMatchers("/info", "/contact").permitAll()
                        .anyRequest().authenticated())
                .formLogin(form -> form.permitAll())
                .logout(lg -> lg.permitAll());
        return httpSecurity.build();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.builder().username("Nitin").password(bCryptPasswordEncoder().encode("1234")).roles("USER").build();
        UserDetails admin =
                User.builder().username("Nikita").password(bCryptPasswordEncoder().encode("5678")).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user,admin);
    }
    @Bean public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
