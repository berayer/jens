package com.zbx.jens.system.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author zbx
 * @date 2023/5/24
 * @description
 **/
@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {

    private final AuthenticationService authenticationService = new AuthenticationService();

    private final CustomAccessDeniedHandler customAccessDeniedHandler;

    public WebSecurityConfig (CustomAccessDeniedHandler customAccessDeniedHandler) {
        this.customAccessDeniedHandler = customAccessDeniedHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 设置保护路径
        http.authorizeHttpRequests(author -> author
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        .requestMatchers("/error", "/user/**").permitAll()
                        .anyRequest().authenticated())
                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler);
        // 关闭默认表单认证
        http.formLogin().disable();
        // 关闭CSRF
        http.csrf().disable();
        // 关闭BASIC认证登陆
        http.httpBasic().disable();
        // 关闭请求缓存
        http.requestCache().disable();
        // 关闭匿名登陆
//        http.anonymous().disable();
        // 关闭记住我服务
        http.rememberMe().disable();
        // 开启跨域
        http.cors().and();
        http.apply(new MyCustomDsl(authenticationService));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder delegatingPasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encode = delegatingPasswordEncoder.encode("123456");
        System.out.println("encode = " + encode);
        return delegatingPasswordEncoder;
    }

    @Bean
    public AuthenticationService authenticationService() {
        return authenticationService;
    }
}
