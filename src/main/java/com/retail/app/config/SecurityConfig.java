package com.retail.app.config;

import org.springframework.context.annotation.Configuration;


@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
public class SecurityConfig {

   /* @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){

        UserDetails admin= User.withUsername("naren")
                .password(encoder.encode("pwd"))
                .roles("ADMIN")
                .build();

        UserDetails user=User.withUsername("neeru")
                .password(encoder.encode("pwd"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin,user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http.authorizeHttpRequests((authorize)->authorize
                .requestMatchers("/api/employees/").permitAll()
                .requestMatchers("/api/employees/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        ).formLogin((form)->form
                .loginPage("/login")
                .permitAll());

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }*/
}
