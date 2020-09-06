package com.miniweibo.user.module.follow.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miniweibo.common.service.AbstractServiceImpl;
import com.miniweibo.user.module.follow.dao.UserFollowMapper;
import com.miniweibo.user.module.follow.entity.UserFollow;
import com.miniweibo.user.module.follow.service.UserFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nicolas.chan
 * 2020/9/5
 */
@Service
public class UserFollowServiceImpl extends AbstractServiceImpl<UserFollow, Long> implements UserFollowService {
    @Autowired
    private UserFollowMapper userFollowMapper;

    @Override
    protected BaseMapper<UserFollow> getMapper() {
        return userFollowMapper;
    }
}
