package com.miniweibo.common.config;

import com.miniweibo.common.interceptor.AuthenticationInterceptor;
import com.miniweibo.common.interceptor.RepeatedRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xiaoshun.cxs
 * @date 2020/8/25
 **/
@Component
public class InterceptorConfigurer implements WebMvcConfigurer {
    @Autowired
    private RepeatedRequestInterceptor repeatedRequestInterceptor;
    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(repeatedRequestInterceptor).addPathPatterns("**");
        registry.addInterceptor(authenticationInterceptor).excludePathPatterns("/register");
    }

}
