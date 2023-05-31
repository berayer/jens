package com.zbx.jens.system.config.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.context.SecurityContextRepository;

/**
 * @author zbx
 * @date 2023/5/30
 * @description
 **/
@Setter
@Slf4j
public class AuthenticationService {

    private final SecurityContextHolderStrategy contextHolderStrategy = SecurityContextHolder.getContextHolderStrategy();
    private AuthenticationManager authenticationManager;
    private SecurityContextRepository securityContextRepository;
    private SessionAuthenticationStrategy sessionAuthenticationStrategy;

    public void login(Authentication auth, boolean rememberMe, HttpServletRequest request, HttpServletResponse response) {
        // 认证管理器认证
        Authentication authenticate = authenticationManager.authenticate(auth);
        // session认证策略
        sessionAuthenticationStrategy.onAuthentication(authenticate, request, response);
        // 创建一个空的上下文
        SecurityContext context = contextHolderStrategy.createEmptyContext();
        // 设置认证之后的信息
        context.setAuthentication(authenticate);
        // 储存安全上下文凭据
        contextHolderStrategy.setContext(context);
        // 服务器保存认证之后的凭据
        securityContextRepository.saveContext(context, request, response);
        log.info("用户登陆成功: {}", authenticate.getName());
    }

}
