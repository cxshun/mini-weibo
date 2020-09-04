package com.miniweibo.user.interceptor;

import com.miniweibo.common.annotation.ValidateAuth;
import com.miniweibo.common.constant.MessageCode;
import com.miniweibo.common.exception.BizException;
import com.miniweibo.common.interceptor.RepeatedRequestWrapper;
import com.miniweibo.user.module.user.service.impl.JwtService;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiaoshun.cxs
 * @date 2020/8/25
 **/
@Component
@Slf4j
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private JwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request instanceof RepeatedRequestWrapper) {
            RepeatedRequestWrapper repeatedRequestWrapper = (RepeatedRequestWrapper)request;
            String body = repeatedRequestWrapper.getBody();
            log.info("request:[{}], body:[{}]", request.getRequestURL().toString(), body);
        }

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod)handler;
        if (handlerMethod.hasMethodAnnotation(ValidateAuth.class)) {
            ValidateAuth validateAuth = handlerMethod.getMethodAnnotation(ValidateAuth.class);
            if (validateAuth == null || !validateAuth.required()) {
                return true;
            }

            String token = request.getHeader("token");
            if (token == null) {
                throw new BizException(MessageCode.CUSTOM_ERROR, "token error");
            }

            Claims claims = jwtService.getClaims(token);
            if (claims == null) {
                throw new BizException(MessageCode.CUSTOM_ERROR, "token error");
            }
        }
        return super.preHandle(request, response, handler);
    }

}
