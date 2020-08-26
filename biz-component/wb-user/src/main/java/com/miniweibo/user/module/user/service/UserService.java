package com.miniweibo.user.module.user.service;

import com.miniweibo.common.service.BaseService;
import com.miniweibo.user.module.user.bo.UserInfoBo;
import com.miniweibo.user.module.user.entity.User;

/**
 * @author nicolas.chan
 * 2020/8/24
 */
public interface UserService extends BaseService<User, Long> {

    /**
     * new register user
     * @param userInfoBo    userInfo entity
     * @return  true-success, false-fail
     */
    boolean register(UserInfoBo userInfoBo);

    /**
     * generate jwt for user
     * @param uid   user id
     * @param password user password
     * @return  jwt
     */
    String authenticate(Long uid, String password);

}
