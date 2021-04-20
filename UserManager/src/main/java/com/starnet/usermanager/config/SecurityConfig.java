package com.starnet.usermanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login.html")
                .and()
                .authorizeRequests()
                .antMatchers("/js/**", "/css/**", "/images/**", "/fonts/**").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/login.html").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();

        http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter();
        loginFilter.setAuthenticationManager(authenticationManagerBean());
        loginFilter.setFilterProcessesUrl("/security-signin");
        loginFilter.setUsernameParameter("uname");
        loginFilter.setPasswordParameter("ucode");
        loginFilter.setAuthenticationSuccessHandler(new MyAuthenticationSuccessHandler("index.html"));
        loginFilter.setAuthenticationFailureHandler(new MyAuthenticationFailureHandler());
        return loginFilter;
    }

    @Bean
    public PasswordEncoder getPw(){
        return new BCryptPasswordEncoder();
    }


}
