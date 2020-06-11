package com.sda.securityproject.configuration;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder encoder;

    @Autowired
    public SecurityConfiguration(PasswordEncoder encoder){
        this.encoder = encoder;
    }


    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }



    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/","/console/**","/home","/sign-in","/sign-up","/added")
                .permitAll()
                .antMatchers("/admin")
                .authenticated().and()
                .formLogin()
                .loginPage("/sign-in")
                .permitAll().and();

        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }

    /*@Bean
    @Override
    protected UserDetailsService userDetailsService(){
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("vlad")
                .password("vlad")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(userDetails);

    }*/

    @Bean
    @Override
    protected UserDetailsService userDetailsService(){
        UserDetails userDetails = User.builder()
                .username("vlad")
                .password(encoder.encode("vlad"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }



}
