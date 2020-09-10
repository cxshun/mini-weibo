package com.miniweibo.user.filter;

import com.miniweibo.user.module.user.service.impl.JwtService;
import com.miniweibo.user.module.user.service.impl.JwtUserDetailServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author nicolas.chan
 * 2020/9/6
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter{
    @Autowired
    private JwtUserDetailServiceImpl jwtUserDetailService;
    @Autowired
    private JwtService jwtService;

    private static final String TOKEN_PREFIX = "Bearer ";
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestToken = request.getHeader("Authorization");
        String token = null, username = null;
        if (requestToken != null && requestToken.startsWith(TOKEN_PREFIX)) {
            token = StringUtils.removeStart(requestToken, TOKEN_PREFIX);
            username = jwtService.getUserNameFromToken(token);
        }

        if (StringUtils.isNotEmpty(username) && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.jwtUserDetailService.loadUserByUsername(username);
            if (jwtService.isValid(token, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
