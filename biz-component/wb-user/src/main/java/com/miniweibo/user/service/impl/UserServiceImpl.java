package com.miniweibo.user.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miniweibo.common.service.AbstractServiceImpl;
import com.miniweibo.user.dao.UserMapper;
import com.miniweibo.user.entity.User;
import com.miniweibo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nicolas.chan
 * 2020/8/24
 */
@Service
public class UserServiceImpl extends AbstractServiceImpl<User, Long> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    protected BaseMapper<User> getMapper() {
        return userMapper;
    }
}
