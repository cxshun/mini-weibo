package com.miniweibo.comment.modules.comment.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miniweibo.comment.modules.comment.dao.CommentMapper;
import com.miniweibo.comment.modules.comment.entity.Comment;
import com.miniweibo.comment.modules.comment.service.CommentService;
import com.miniweibo.common.service.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nicolas.chan
 * 2020/9/6
 */
@Service
public class CommentServiceImpl extends AbstractServiceImpl<Comment, Long> implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    protected BaseMapper<Comment> getMapper() {
        return commentMapper;
    }
}
