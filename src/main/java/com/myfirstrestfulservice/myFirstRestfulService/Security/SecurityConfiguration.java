package com.myfirstrestfulservice.myFirstRestfulService.Security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
                .inMemoryAuthentication()
                //====Authorized Users====================================================================
                .withUser("jay")
                .password(encoder.encode("123318"))
                .roles("USER")
                .and()
                .withUser("test1")
                .password(encoder.encode("test1p@ss"))
                .roles("USER")
                .and()
                .withUser("a4f6c147-f637-4fc3-88f0-e84627de6251")
                .password(encoder.encode("79124d23-f1ab-47fa-b0fb-89fb00890f9b"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(encoder.encode("n1md@!"))
                .roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .anonymous()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/error/**", "/swagger-ui.html","/v2/api-docs").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}
