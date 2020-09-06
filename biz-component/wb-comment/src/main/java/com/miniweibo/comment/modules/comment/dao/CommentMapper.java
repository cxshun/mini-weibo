package com.miniweibo.comment.modules.comment.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miniweibo.comment.modules.comment.entity.Comment;
import org.springframework.stereotype.Repository;

/**
 * @author nicolas.chan
 * 2020/9/6
 */
@Repository
public interface CommentMapper extends BaseMapper<Comment> {
}
