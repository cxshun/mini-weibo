package com.miniweibo.user.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
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
public class JwtServiceImpl {
    /**
     * 过期时间
     */
    private static final Long EXPIRE_IN_MILLIS = 5 * 60 * 60 * 1000L;

    @Value("${jwt.secret}")
    private String secret;

    /**
     * generate jwt token
     * @param userDetails   userDetails
     * @return  jwt token
     */
    private String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(new HashMap<>(0))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_IN_MILLIS))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * get username from token
     * @param token jwt token
     * @return username
     */
    private String getUserNameFromToken(String token) {
        return doGetClaimsFromToken(token, Claims::getSubject);
    }

    private <T> T doGetClaimsFromToken(String token, Function<Claims, T> tFunction) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return tFunction.apply(claims);
    }

}
