package com.example.shomsy.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
*/

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence rawPassword) {
//                return null;
//            }
//
//            @Override
//            public boolean matches(CharSequence rawPassword, String encodedPassword) {
//                return true;
//            }
//        };
//    }


//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .requestMatchers(HttpMethod.POST, "/User/**").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.DELETE, "/User/**").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.GET, "/User/**").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.POST, "/Store/**").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.DELETE, "/Store/**").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.GET, "/Store/**").hasRole("ADMIN")
//                .requestMatchers("/Product/**").hasAnyRole("MANAGER")
//                .requestMatchers(HttpMethod.DELETE, "/Product/**").hasRole("MANAGER")
//                .requestMatchers(HttpMethod.GET, "/Product/**").hasRole("MANAGER")
//
//                .anyRequest()
//                .authenticated();
//        return http.build();
//    }
}