package com.miniweibo.comment.modules.reply.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miniweibo.comment.modules.reply.dao.ReplyMapper;
import com.miniweibo.comment.modules.reply.entity.Reply;
import com.miniweibo.comment.modules.reply.service.ReplyService;
import com.miniweibo.common.service.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nicolas.chan
 * 2020/9/6
 */
@Service
public class ReplyServiceImpl extends AbstractServiceImpl<Reply, Long> implements ReplyService {
    @Autowired
    private ReplyMapper replyMapper;

    @Override
    protected BaseMapper<Reply> getMapper() {
        return replyMapper;
    }
}
