package com.miniweibo.common.interceptor;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiaoshun.cxs
 * @date 2020/8/25
 **/
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class RepeatedRequestInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request = new RepeatedRequestWrapper(request);
        return super.preHandle(request, response, handler);
    }
}
