package com.miniweibo.user.module.user.service.impl;

import com.miniweibo.user.config.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

/**
 * @author xiaoshun.cxs
 * @date 2020/8/25
 **/
@Component
public class JwtService {
    @Autowired
    private JwtConfig jwtConfig;

    /**
     * generate jwt token
     * @param userDetails   userDetails
     * @return  jwt token
     */
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(new HashMap<>(0))
                .setSubject(userDetails.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + jwtConfig.getExpire() * 1000L))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret())
                .compact();
    }

    /**
     * get username from token
     * @param token jwt token
     * @return username
     */
    public String getUserNameFromToken(String token) {
        return doGetClaimsFromToken(token, Claims::getSubject);
    }

    private <T> T doGetClaimsFromToken(String token, Function<Claims, T> tFunction) {
        Claims claims = getClaims(token);
        return tFunction.apply(claims);
    }

    /**
     * get claims from token
     * @param token jwt token
     * @return claims
     */
    public Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(jwtConfig.getSecret()).parseClaimsJws(token).getBody();
    }

    /**
     * check if token is expire
     * @param token current token
     * @return  true-available, false-expired
     */
    private boolean isTokenExpired(String token) {
        final Date expiration = doGetClaimsFromToken(token, Claims::getExpiration);
        return expiration.after(new Date());
    }

    /**
     * check if token is valid
     * @param token token
     * @param userDetails   userdetails
     * @return true-valid, false-not
     */
    public boolean isValid(String token, UserDetails userDetails) {
        String username = doGetClaimsFromToken(token, Claims::getSubject);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

}
