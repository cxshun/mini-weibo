package com.miniweibo.user.module.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author xiaoshun.cxs
 * 2020/8/24
 */
@Data
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
    private String loginId;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 密码，经过加密的
     */
    private String password;
    /**
     * 用户角色
     */
    private String role;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 用户头像
     */
    private String logoUrl;
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
    @TableLogic
    private Integer isDeleted;

}
