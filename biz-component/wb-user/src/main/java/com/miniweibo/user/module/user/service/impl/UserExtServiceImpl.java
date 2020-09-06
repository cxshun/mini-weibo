package com.miniweibo.user.module.user.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miniweibo.common.service.AbstractServiceImpl;
import com.miniweibo.user.module.user.dao.UserExtMapper;
import com.miniweibo.user.module.user.entity.UserExt;
import com.miniweibo.user.module.user.service.UserExtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nicolas.chan
 * 2020/9/5
 */
@Service
public class UserExtServiceImpl extends AbstractServiceImpl<UserExt, Long> implements UserExtService {
    @Autowired
    private UserExtMapper userExtMapper;

    @Override
    protected BaseMapper<UserExt> getMapper() {
        return userExtMapper;
    }
}
