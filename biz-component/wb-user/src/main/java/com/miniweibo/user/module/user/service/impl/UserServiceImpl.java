package com.miniweibo.user.module.user.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miniweibo.common.constant.CommonConstant;
import com.miniweibo.common.service.AbstractServiceImpl;
import com.miniweibo.user.module.user.bo.UserInfoBo;
import com.miniweibo.user.module.user.dao.UserMapper;
import com.miniweibo.user.module.user.entity.User;
import com.miniweibo.user.module.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author nicolas.chan
 * @date 2020/8/24
 */
@Slf4j
@Service
public class UserServiceImpl extends AbstractServiceImpl<User, Long> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtService jwtService;

    @Override
    protected BaseMapper<User> getMapper() {
        return userMapper;
    }

    @Override
    public boolean register(UserInfoBo userInfoBo) {
        Date date = new Date();

        User user = new User();
        BeanUtils.copyProperties(userInfoBo, user);
        user.setCreateTime(date);
        user.setUpdateTime(date);
        user.setIsDeleted(CommonConstant.FALSE);
        userMapper.insert(user);

        //omit password for the security reason
        user.setPassword(null);
        log.info("user:[{}] register success", userInfoBo);
        return true;
    }

    @Override
    public String authenticate(Long uid, String password) {
        return "";
    }
}
