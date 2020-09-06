package com.miniweibo.topic.modules.topic.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName
@Data
public class Topic {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 用户ID
     */
    private Long uid;
    /**
     * 标题
     */
    private String title;
    /**
     * 回复个数
     */
    private Integer commentCount;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 是否删除 ，1-是，0-否
     */
    @TableLogic
    private Byte isDeleted;

}