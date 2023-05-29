package com.project.quizzeria.securityConfig;


import com.project.quizzeria.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    private final MemberServiceImpl memberServiceImpl;

    @Override //resources에 보안을 걸지 않는다 bootstrap 사용시 css폴더에 첨부해야만 사용가능
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/**", "/js/**", "/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/main/**", "/member/member_register").permitAll()
                    .antMatchers("/").hasRole("USER")
                    .antMatchers("/member/member_admin").hasRole("AMDIN")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/member/member_login").permitAll()
                    .usernameParameter("id")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/main/welcome")
                    .and()
                .logout()
                    .logoutSuccessUrl("/member/member_login")
                    .invalidateHttpSession(true)
                ;
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(memberServiceImpl)
                .passwordEncoder(new BCryptPasswordEncoder());
    }


}


