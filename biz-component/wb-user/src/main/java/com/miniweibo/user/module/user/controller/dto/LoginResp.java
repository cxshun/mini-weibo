package com.miniweibo.user.module.user.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nicolas.chan
 * 2020/9/6
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResp {

    /**
     * 认证的token
     */
    private String token;

}
