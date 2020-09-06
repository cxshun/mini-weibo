package com.miniweibo.user.module.user.controller.dto;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author nicolas.chan
 * 2020/9/6
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class LoginReq {

    @NotNull
    private String loginId;

    @NotNull
    private String password;

}
