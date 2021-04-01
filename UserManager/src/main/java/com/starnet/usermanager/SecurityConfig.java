//package com.starnet.usermanager;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.io.PrintWriter;
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("Abr")
//                .password("123456")
//                .roles("admin");
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception{
//        web.ignoring().antMatchers("/js/**","/css/**","/images/**","/fonts/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login.html")
//                .loginProcessingUrl("/signin")
//                .successHandler((req, resp, authentication)->{
//                    resp.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = resp.getWriter();
//                    out.write(new ObjectMapper().writeValueAsString(authentication.getPrincipal()));
//                    out.flush();
//                    out.close();
//                })
//                .failureHandler((req, resp, exception)->{
//                    resp.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = resp.getWriter();
//                    out.write(new ObjectMapper().writeValueAsString(exception.getMessage()));
//                    out.flush();
//                    out.close();
//                })
//                .permitAll()
//                .and()
//                .logout()
//                .logoutSuccessHandler((req, resp ,authentication)->{
//                    resp.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = resp.getWriter();
//                    out.write(new ObjectMapper().writeValueAsString("注销成功"));
//                    out.flush();
//                    out.close();
//                })
//                .and()
//                .csrf().disable()
//                .exceptionHandling()
//                .authenticationEntryPoint((req, resp, exception)->{
//                    resp.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = resp.getWriter();
//                    out.write(new ObjectMapper().writeValueAsString("尚未登录，请登录"));
//                    out.flush();
//                    out.close();
//                });
//
//    }
//
//}
