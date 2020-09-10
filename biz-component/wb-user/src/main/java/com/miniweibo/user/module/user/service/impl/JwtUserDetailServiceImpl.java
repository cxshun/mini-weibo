package com.miniweibo.user.module.user.service.impl;

import com.miniweibo.common.exception.BizException;
import com.miniweibo.user.module.user.entity.JwtUser;
import com.miniweibo.user.module.user.entity.User;
import com.miniweibo.user.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author nicolas.chan
 * 2020/9/6
 */
@Service
public class JwtUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        try {
            User user = userService.getByLoginId(loginId);
            return new JwtUser(user);
        } catch (BizException e) {
            throw new UsernameNotFoundException(String.format("username:[%s] not found", loginId));
        }
    }
}
