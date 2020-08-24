package com.miniweibo.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @author xiaoshun.cxs
 * 2020/8/24
 */
@TableName("`user`")
public class User {

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 密码，经过加密的
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 性别，0-女，1-男，2-未知
     */
    private Integer sex;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 是否删除
     */
    private Integer isDeleted;

}
