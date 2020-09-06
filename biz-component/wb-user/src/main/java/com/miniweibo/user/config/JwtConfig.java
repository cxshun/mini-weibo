package com.miniweibo.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author nicolas.chan
 * 2020/9/6
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {
    /**
     * 过期时间，默认为7天，单位为秒
     */
    private Integer expire = 604800;
    /**
     * jwt secret
     */
    private String secret;

}
