package com.zbx.jens.system.config.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.context.SecurityContextRepository;

/**
 * @author zbx
 * @date 2023/5/30
 * @description
 **/
public class MyCustomDsl extends AbstractHttpConfigurer<MyCustomDsl, HttpSecurity> {

    private final AuthenticationService authenticationService;

    public MyCustomDsl(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public void init(HttpSecurity http) throws Exception {
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
        SecurityContextRepository securityContextRepository = http.getSharedObject(SecurityContextRepository.class);
        authenticationService.setAuthenticationManager(authenticationManager);
        authenticationService.setSecurityContextRepository(securityContextRepository);
        authenticationService.setSessionAuthenticationStrategy(http.getSharedObject(SessionAuthenticationStrategy.class));
    }

}