package com.miniweibo.user.module.follow.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miniweibo.user.module.follow.entity.UserFollow;
import org.springframework.stereotype.Repository;

/**
 * @author nicolas.chan
 * 2020/9/5
 */
@Repository
public interface UserFollowMapper extends BaseMapper<UserFollow> {
}
