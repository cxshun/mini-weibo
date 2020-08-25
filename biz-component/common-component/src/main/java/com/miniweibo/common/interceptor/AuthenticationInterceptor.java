package com.miniweibo.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
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

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request instanceof RepeatedRequestWrapper) {
            RepeatedRequestWrapper repeatedRequestWrapper = (RepeatedRequestWrapper)request;
            String body = repeatedRequestWrapper.getBody();
            log.info("request:[{}], body:[{}]", request.getRequestURL().toString(), body);
        }
        return super.preHandle(request, response, handler);
    }

}
