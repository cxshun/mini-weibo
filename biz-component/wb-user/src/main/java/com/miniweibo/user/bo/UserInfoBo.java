package com.miniweibo.user.bo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author nicolas.chan
 * 2020/8/24
 */
@Data
@Accessors(chain = true)
public class UserInfoBo {

    private String nickName;
    private String name;
    private String email;
    private String password;
    private Integer sex;

}
