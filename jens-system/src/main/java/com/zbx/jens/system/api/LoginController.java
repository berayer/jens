package com.zbx.jens.system.api;

import com.zbx.jens.core.response.Result;
import com.zbx.jens.system.config.security.AuthenticationService;
import com.zbx.jens.system.pojo.form.LoginForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbx
 * @date 2023/5/24
 * @description
 **/
@RestController
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final AuthenticationService authService;

    /**
     * 用户登陆接口
     * @param loginForm 登陆表单
     * @return 200
     */
    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginForm loginForm, HttpServletRequest request, HttpServletResponse response) {
        log.info("用户请求登陆: {}", loginForm);
        UsernamePasswordAuthenticationToken unauthenticatedToken = UsernamePasswordAuthenticationToken.unauthenticated(loginForm.getUsername(), loginForm.getPassword());
        authService.login(unauthenticatedToken, loginForm.isRememberMe(), request, response);
        String token = response.getHeader("set-cookie");
        return Result.success(token);
    }

    @PostMapping("/logout")
    public Result<String> logout() {
        return Result.success();
    }

    @PostMapping("/refreshToken")
    public Result<String> refreshToken() {
        return Result.success();
    }

}
