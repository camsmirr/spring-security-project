
package com.sevensevengsi.laundry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

    @EnableWebSecurity
    @Configuration
    public class SecurityConfig  {

        UserDetailsService userDetailsService;

        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        public UserDetailsService userDetailsService() {
            return userDetailsService;
        }

        public DaoAuthenticationProvider authenticationProvider() {
            DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
            authProvider.setUserDetailsService(userDetailsService());
            authProvider.setPasswordEncoder(passwordEncoder());
            return authProvider;
        }

        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.authenticationProvider(authenticationProvider());
        }
        @Bean
        protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                   .antMatchers("/form","/login").permitAll()
                    .antMatchers("/page/all").permitAll()
                    .antMatchers("/page/manager/**").hasRole("MANAGER")
                    .antMatchers("/page/admin/**").hasRole("ADMIN")
                    .antMatchers("/page/customer/**").hasRole("CUSTOMER")
                    .antMatchers("/page/owner/**").hasRole("OWNER")
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .permitAll()
                    .and()
                    .logout().permitAll()
                    .and()
                    .exceptionHandling().accessDeniedPage("/access_denied");
            return http.build();
        }
}
