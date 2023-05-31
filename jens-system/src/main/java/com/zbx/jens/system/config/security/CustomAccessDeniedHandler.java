package com.zbx.jens.system.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zbx.jens.core.response.Result;
import com.zbx.jens.core.response.Status;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zbx
 * @date 2023/5/31
 * @description
 **/
@Slf4j
@Component
@RequiredArgsConstructor
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private final ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        if (response.isCommitted()) {
            log.trace("Did not write to response since already committed");
        } else {
            log.debug("Responding with 403 status code");
            response.setStatus(HttpStatus.FORBIDDEN.value());
            Result<String> res = Result.ofStatus(Status.FORBIDDEN);
            PrintWriter writer = response.getWriter();
            writer.println(objectMapper.writeValueAsString(res));
            writer.flush();
        }
    }
}
